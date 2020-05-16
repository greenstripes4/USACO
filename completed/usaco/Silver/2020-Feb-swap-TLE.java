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
        BufferedReader f = new BufferedReader(new FileReader("swap.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] cows = new int[N];
        for(int i = 0; i < cows.length; i++){
            cows[i] = i+1;
        }
        int[][] instructions = new int[M][2];
        for(int i = 0; i < M; i++){
            StringTokenizer ins = new StringTokenizer(f.readLine());
            instructions[i][0] = Integer.parseInt(ins.nextToken())-1;
            instructions[i][1] = Integer.parseInt(ins.nextToken())-1;
        }
        for(int i = 0; i < K; i++){
            for(int[] j: instructions){
                int p1 = j[0];
                int p2 = j[1];
                while(p1 < p2){
                    int original = cows[p1];
                    cows[p1] = cows[p2];
                    cows[p2] = original;
                    p1++;
                    p2--;
                }
            }
        }
        for(int i: cows){
            out.println(i);
        }
        out.close();
        f.close();
    }
}
