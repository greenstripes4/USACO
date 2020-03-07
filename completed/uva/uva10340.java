/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main{
    public static boolean isSubsequence(String s, String t) {
        char[] w1 = s.toCharArray();
        char[] w2 = t.toCharArray();
        int p1 = 0;
        int p2 = 0;
        while(p2 < w2.length && p1 < w1.length){
            if(w1[p1] == w2[p2]){
                p1++;
            }
            p2++;
        }
        return p1 == w1.length;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null){
            StringTokenizer st = new StringTokenizer(input);
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            out.println(isSubsequence(s1,s2) ? "Yes" : "No");
        }
        out.close();
        f.close();
    }
}
