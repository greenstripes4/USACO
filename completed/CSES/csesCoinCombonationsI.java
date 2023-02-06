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
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        StringTokenizer stringTokenizer = new StringTokenizer(f.readLine());
        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        long[] value = new long[sum+1];
        value[0] = 1;
        for (int x = 1; x <= sum; x++) {
            for (int c : coins) {
                if (x-c >= 0) {
                    value[x] += value[x-c];
                    value[x] = value[x]%1000000007;
                }
            }
        }
        out.println(value[sum]);
        out.close();
        f.close();
    }
}
