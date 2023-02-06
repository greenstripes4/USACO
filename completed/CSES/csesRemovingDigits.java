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
        //BufferedReader f = new BufferedReader(new FileReader("loan.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int steps = 0;
        while(n != 0){
            int max = 0;
            int temp = n;
            while(temp != 0){
                if(n - temp%10 >= 0){
                    max = Math.max(temp%10,max);
                }
                temp /= 10;
            }
            n -= max;
            steps++;
        }
        out.println(steps);
        out.close();
        f.close();
    }
}
