/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("cecs.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n-1; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        for(int i = 1; i <= n; i++){
            if(!set.contains(i)){
                out.println(i);
                break;
            }
        }
        f.close();
        out.close();
    }
}
