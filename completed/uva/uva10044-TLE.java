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
            int P = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            HashMap<String,HashSet<String>> map = new HashMap<>();
            for(int i = 0; i < P; i++){
                String[] authors = f.readLine().split(":")[0].split(", ");
                String[] authorsFormatted = new String[authors.length/2];
                int ind = 0;
                for(int j = 0; j < authors.length; j += 2){
                    authorsFormatted[ind] = authors[j] + ", " + authors[j+1];
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
            out.println("Scenario " + (s+1));
            for(int i = 0; i < N; i++){
                String query = f.readLine();
                if(!map.containsKey(query)){
                    out.println(query + " infinity");
                    continue;
                }
                Queue<String> queue = new LinkedList<>();
                queue.add(query);
                HashSet<String> seen = new HashSet<>();
                boolean found = false;
                int distance = 0;
                while(!queue.isEmpty()){
                    int size = queue.size();
                    for(int j = 0; j < size; j++){
                        String next = queue.poll();
                        if(next.equals("Erdos, P.")){
                            found = true;
                            break;
                        }
                        for(String k: map.get(next)){
                            if(!seen.contains(k)){
                                queue.add(k);
                                seen.add(k);
                            }
                        }
                    }
                    if(found){
                        break;
                    }
                    distance++;
                }
                if(!found){
                    out.println(query + " infinity");
                    continue;
                }
                out.println(query + " " + distance);
            }
        }
        f.close();
        out.close();
    }
}
