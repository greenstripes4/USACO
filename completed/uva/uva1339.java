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
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null){
            char[] w1 = input.toCharArray();
            char[] w2 = f.readLine().toCharArray();
            int[] c1 = new int[26];
            int[] c2 = new int[26];
            for(char i: w1){
                c1[i-'A']++;
            }
            for(char i: w2){
                c2[i-'A']++;
            }
            Arrays.sort(c1);
            Arrays.sort(c2);
            out.println(Arrays.equals(c1,c2) ? "YES":"NO");
        }
        out.close();
        f.close();
    }
}
