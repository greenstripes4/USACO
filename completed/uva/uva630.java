import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            if(t > 0) {
                out.println();
            }
            f.readLine();
            int N = Integer.parseInt(f.readLine());
            HashMap<String,ArrayList<String>> map = new HashMap<>();
            for(int i = 0; i < N; i++) {
                String next = f.readLine();
                char[] arr = next.toCharArray();
                Arrays.sort(arr);
                String sortedKey = String.valueOf(arr);
                if(map.containsKey(sortedKey)) {
                    map.get(sortedKey).add(next);
                } else {
                    ArrayList<String> temp = new ArrayList<>();
                    temp.add(next);
                    map.put(sortedKey,temp);
                }
            }
            String query;
            while(!(query = f.readLine()).equals("END")) {
                char[] sorted = query.toCharArray();
                Arrays.sort(sorted);
                String key = String.valueOf(sorted);
                out.println("Anagrams for: " + query);
                if(map.containsKey(key)) {
                    int number = 1;
                    for(String i: map.get(key)) {
                        out.printf("%3d",number);
                        out.println(") " + i);
                        number++;
                    }
                } else {
                    out.println("No anagrams for: " + query);
                }
            }
        }
        f.close();
        out.close();
    }
}
