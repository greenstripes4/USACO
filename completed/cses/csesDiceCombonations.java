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
        int[] arr = new int[Math.max(n+1,6)];
        arr[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.max(0, i - 6); j < i; j++) {
                arr[i] = (arr[i] + arr[j]) % 1000000007;
            }
        }
        out.println(arr[n]);
        out.close();
        f.close();
    }
}
