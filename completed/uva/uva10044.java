import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int scenarios = Integer.parseInt(f.readLine());
        for(int s = 0; s < scenarios; s++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            while(st.countTokens() != 2) {
                st = new StringTokenizer(f.readLine());
            }
            int P = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            HashMap<String,HashSet<String>> map = new HashMap<>();
            for(int i = 0; i < P; i++){
                String[] authors = f.readLine().split(":")[0].split(",\\s*");
                String[] authorsFormatted = new String[authors.length/2];
                int ind = 0;
                for(int j = 0; j < authors.length; j += 2){
                    if(j < authors.length-1) {
                        authorsFormatted[ind] = authors[j].trim() + "," + authors[j+1].trim();
                    } else {
                        authorsFormatted[ind] = authors[j].trim();
                    }
                    ind++;
                }
                for(int j = 0; j < authorsFormatted.length; j++){
                    for(int k = 0; k < authorsFormatted.length; k++){
                        if(j != k){
                            if(map.containsKey(authorsFormatted[j])){
                                map.get(authorsFormatted[j]).add(authorsFormatted[k]);
                            } else {
                                HashSet<String> temp = new HashSet<>();
                                temp.add(authorsFormatted[k]);
                                map.put(authorsFormatted[j],temp);
                            }
                        }
                    }
                }
            }
            Queue<String> queue = new LinkedList<>();
            queue.add("Erdos,P.");
            HashMap<String,Integer> erdosNumbers = new HashMap<>();
            erdosNumbers.put("Erdos,P.",0);
            while(!queue.isEmpty()) {
                String next = queue.poll();
                for(String i: map.get(next)) {
                    if(!erdosNumbers.containsKey(i)) {
                        queue.add(i);
                        erdosNumbers.put(i, erdosNumbers.get(next) + 1);
                    }
                }
            }
            out.println("Scenario " + (s+1));
            for(int i = 0; i < N; i++){
                String input = f.readLine();
                String[] queryParts = input.trim().split(",\\s*");
                String query = queryParts[0]+","+queryParts[1];
                if(!map.containsKey(query) || !erdosNumbers.containsKey(query)){
                    out.println(input + " infinity");
                    continue;
                }
                out.println(input + " " + erdosNumbers.get(query));
            }
        }
        f.close();
        out.close();
    }
}
