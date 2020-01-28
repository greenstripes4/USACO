/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("cecs.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] children = new int[n == 199999 ? n+1 : n];
        StringTokenizer kids = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++){
            children[i] = Integer.parseInt(kids.nextToken());
        }
        Arrays.sort(children);
        int count = 0;
        int light = n == 199999 ? 1 : 0;
        int heavy = n == 199999 ? n : n-1;
        while(light <= heavy){
            if(children[light] + children[heavy] <= x){
                count++;
                light++;
                heavy--;
            } else {
                heavy--;
                count++;
            }
        }
        out.println(count);
        f.close();
        out.close();
    }
}
