/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("cecs.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCases = Integer.parseInt(f.readLine());
        for(int i = 0; i < testCases; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            long y = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long loop = Math.max(y,x);
            long start = (loop-1)*(loop-1) + 1;
            long end = loop*loop;
            if(loop % 2 == 0){
                if(x >= y){
                    out.println(start + y - 1);
                } else {
                    out.println(end - x + 1);
                }
            } else {
                if(x >= y){
                    out.println(end - y + 1);
                } else {
                    out.println(start + x - 1);
                }
            }
        }
        f.close();
        out.close();
    }
}
