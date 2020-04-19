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
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCases = Integer.parseInt(f.readLine());
        for(int i = 1; i <= testCases; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());
            int fi = Integer.parseInt(st.nextToken());
            int at = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int c3 = Integer.parseInt(st.nextToken());
            int sc = t1+t2+fi+at+(c1+c2+c3-Math.min(Math.min(c1,c2),c3))/2;
            if(sc >= 90){
                out.println("Case " + i + ": A");
            } else if(sc >= 80) {
                out.println("Case " + i + ": B");
            } else if(sc >= 70) {
                out.println("Case " + i + ": C");
            } else if(sc >= 60) {
                out.println("Case " + i + ": D");
            } else {
                out.println("Case " + i + ": F");
            }
        }
        out.close();
        f.close();
    }
}
