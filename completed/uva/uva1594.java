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
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int T = Integer.parseInt(f.readLine());
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(f.readLine());
            int[] ducciSequence = new int[n];
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 0; j < n; j++){
                ducciSequence[j] = Integer.parseInt(st.nextToken());
            }
            int[] zeros = new int[n];
            boolean printed = false;
            for(int j = 0; j < 1000; j++){
                int[] temp = new int[n];
                for(int k = 0; k < n; k++){
                    temp[k] = Math.abs(ducciSequence[k]-ducciSequence[(k+1)%n]);
                }
                ducciSequence = temp;
                if(Arrays.equals(ducciSequence,zeros)){
                    out.println("ZERO");
                    printed = true;
                    break;
                }
            }
            if(!printed){
                out.println("LOOP");
            }
        }
        f.close();
        out.close();
    }
}
