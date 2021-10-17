import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            String[][] table = new String[n][];
            for(int i = 0; i < n; i++) {
                table[i] = f.readLine().split(",");
            }
            boolean flag = false;
            for(int i = 0; i < m; i++) {
                for(int j = i+1; j < m; j++) {
                    HashMap<String, Integer> map = new HashMap<>();
                    for(int k = 0; k < n; k++) {
                        String id = table[k][i]+","+table[k][j];
                        if(map.containsKey(id)) {
                            flag = true;
                            out.println("NO");
                            out.println(map.get(id) + " " + (k+1));
                            out.println((i+1) + " " + (j+1));
                            break;
                        }
                        map.put(id, k+1);
                    }
                    if(flag) {
                        break;
                    }
                }
                if(flag) {
                    break;
                }
            }
            if(!flag) {
                out.println("YES");
            }
        }
        f.close();
        out.close();
    }
}
