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
        int n = Integer.parseInt(f.readLine());
        if(n == 1){
            out.println(1);
        }else if(n < 4){
            out.println("NO SOLUTION");
        } else if (n == 4) {
            out.println("2 4 1 3");
        } else {
            for(int i = 1; i <= n; i += 2){
                out.print(i + " ");
            }
            for(int j = 2; j <= n; j += 2){
                out.print(j + (j >= n-1 ? "":" "));
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
