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
        int N = Integer.parseInt(f.readLine());
        for(int i = 0; i < N; i++){
            int[] count = new int[10];
            int upTo = Integer.parseInt(f.readLine());
            for(int j = 1; j <= upTo; j++){
                int val = j;
                while(val != 0){
                    count[val%10]++;
                    val /= 10;
                }
            }
            for(int j = 0; j < count.length; j++){
                if(j == 0){
                    out.print(count[j]);
                } else {
                    out.print(" " + count[j]);
                }
            }
            out.println();
        }
        out.close();
        f.close();
    }
}
