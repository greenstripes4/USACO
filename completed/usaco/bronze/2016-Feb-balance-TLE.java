import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("balancing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] cowPos = new int[n][2];
        for(int i = 0; i < n; i++){
            StringTokenizer pos = new StringTokenizer(f.readLine());
            cowPos[i] = new int[]{Integer.parseInt(pos.nextToken()),Integer.parseInt(pos.nextToken())};
        }
        int M = n;
        for(int j = 0; j <= b; j += 2){
            for(int k = 0; k <= b; k += 2){
                int c1 = 0;
                int c2 = 0;
                int c3 = 0;
                int c4 = 0;
                for(int[] l: cowPos){
                    if(l[0] < j && l[1] < k){
                        c1++;
                    } else if (l[0] < j && l[1] > k){
                        c2++;
                    } else if (l[0] > j && l[1] < k){
                        c3++;
                    } else {
                        c4++;
                    }
                }
                if(Math.max(Math.max(c1,c2),Math.max(c3,c4)) < M){
                    M = Math.max(Math.max(c1,c2),Math.max(c3,c4));
                }
            }
        }
        out.println(M);
        out.close();
        f.close();
    }
}
