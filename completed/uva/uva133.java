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
        while(true){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(N == 0 && k == 0 && m == 0){
                break;
            }
            int[] people = new int[N];
            for(int i = 1; i <= N; i++){
                people[i-1] = i;
            }
            int clockwise = -1;
            int counterClockwise = N;
            int printed = 0;
            while(printed < N){
                int counter = 0;
                while(counter < k){
                    clockwise++;
                    clockwise = (clockwise+N)%N;
                    if(people[clockwise] != 0) {
                        counter++;
                    }
                }
                counter = 0;
                while(counter < m){
                    counterClockwise--;
                    counterClockwise = (counterClockwise+N)%N;
                    if(people[counterClockwise] != 0) {
                        counter++;
                    }
                }
                out.printf("%3d",people[clockwise]);
                printed++;
                if(clockwise != counterClockwise){
                    out.printf("%3d",people[counterClockwise]);
                    printed++;
                }
                if(printed < N){
                    out.print(",");
                }
                people[clockwise] = 0;
                people[counterClockwise] = 0;
            }
            out.println();
        }
        out.close();
        f.close();
    }
}
