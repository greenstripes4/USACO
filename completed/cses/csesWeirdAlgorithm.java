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
        long n = Integer.parseInt(f.readLine());
        while(n != 1){
            out.print(n + " ");
            if(n%2 == 0){
                n /= 2;
            } else {
                n = 3*n + 1;
            }
        }
        out.println(1);
        f.close();
        out.close();
    }
}
