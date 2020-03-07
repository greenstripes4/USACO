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
        while(!(input = f.readLine()).equals("0")){
            int N = Integer.parseInt(input);
            int[] arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(f.readLine());
            }
            Arrays.sort(arr);
            boolean possible = true;
            for(int i = 0; i < N; i++){
                if((i != N-1 && arr[i+1] - arr[i] > 200) || (i == N-1 && (1422 - arr[i])*2 > 200)){
                    possible = false;
                    break;
                }
            }
            out.println(possible ? "POSSIBLE":"IMPOSSIBLE");
        }
        out.close();
        f.close();
    }
}
