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
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(f.readLine());
            long[][] points = new long[N][2];
            long minX = Long.MAX_VALUE;
            long maxX = Long.MIN_VALUE;
            for(int j = 0; j < N; j++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                points[j][0] = Long.parseLong(st.nextToken())*2;
                points[j][1] = Long.parseLong(st.nextToken());
                minX = Math.min(minX,points[j][0]);
                maxX = Math.max(maxX,points[j][0]);
            }
            long lineX = (minX+maxX)/2;
            boolean[] seen = new boolean[1000];
            boolean valid = true;
            for(int j = 0; j < N; j++){
                if(!seen[j] && points[j][0] != lineX){
                    seen[j] = true;
                    long[] lookFor = {2*lineX-points[j][0],points[j][1]};
                    boolean found = false;
                    for(int k = 0; k < N; k++){
                        if(!seen[k] && Arrays.equals(points[k],lookFor)){
                            seen[k] = true;
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        valid = false;
                        break;
                    }
                }
            }
            out.println(valid ? "YES":"NO");
        }
        f.close();
        out.close();
    }
}
