/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */


import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        while(!(input = f.readLine()).equals("0")){
            int n = Integer.parseInt(input);
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                int leaving = Integer.parseInt(st.nextToken());
                int arriving = Integer.parseInt(st.nextToken());
                map.put(leaving,map.getOrDefault(leaving,0)-1);
                map.put(arriving,map.getOrDefault(arriving,0)+1);
            }
            boolean valid = true;
            for(int j: map.values()){
                if(j != 0){
                    valid = false;
                    out.println("NO");
                    break;
                }
            }
            if(valid){
                out.println("YES");
            }
        }
        f.close();
        out.close();
    }
}
