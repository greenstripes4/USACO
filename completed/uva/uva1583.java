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
        int[] memoization = new int[100001];
        Arrays.fill(memoization,-1);
        int T = Integer.parseInt(f.readLine());
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(f.readLine());
            if(memoization[N-1] != -1){
                out.println(memoization[N-1]);
            } else {
                int least = 0;
                for (int j = Math.max(N-45,1); j <= N; j++) {
                    int sum = j;
                    int val = j;
                    while (val != 0) {
                        sum += val % 10;
                        val /= 10;
                    }
                    if (sum == N) {
                        least = j;
                        break;
                    }
                }
                out.println(least);
                memoization[N-1] = least;
            }
        }
        out.close();
        f.close();
    }
}
