import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());
        int[][] A = new int[H][W];
        for(int i = 0; i < H; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < W; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long ans = Long.MAX_VALUE;
        long[][] dp1 = new long[H][W];
        dp1[0][0] = A[0][0];
        for(int i = 1; i < H; i++) {
            ans = Math.min(ans, A[i][0]+C*i+dp1[i-1][0]);
            dp1[i][0] = Math.min(dp1[i-1][0], A[i][0]-C*i);
        }
        for(int j = 1; j < W; j++) {
            ans = Math.min(ans, A[0][j]+C*j+dp1[0][j-1]);
            dp1[0][j] = Math.min(dp1[0][j-1], A[0][j]-C*j);
        }
        for(int i = 1; i < H; i++) {
            for(int j = 1; j < W; j++) {
                dp1[i][j] = Math.min(dp1[i-1][j], dp1[i][j-1]);
                ans = Math.min(ans, A[i][j]+C*(i+j)+dp1[i][j]);
                dp1[i][j] = Math.min(dp1[i][j], A[i][j]-C*(i+j));
            }
        }
        long[][] dp2 = new long[H][W];
        dp2[0][W-1] = A[0][W-1]+C*(W-1);
        for(int j = W-2; j >= 0; j--) {
            ans = Math.min(ans, A[0][j]-C*j+dp2[0][j+1]);
            dp2[0][j] = Math.min(dp2[0][j+1], A[0][j]+C*j);
        }
        for(int i = 1; i < H; i++) {
            ans = Math.min(ans, A[i][W-1]+C*(i-(W-1))+dp2[i-1][W-1]);
            dp2[i][W-1] = Math.min(dp2[i-1][W-1], A[i][W-1]-C*(i-(W-1)));
        }
        for(int i = 1; i < H; i++) {
            for(int j = W-2; j >= 0; j--) {
                dp2[i][j] = Math.min(dp2[i-1][j], dp2[i][j+1]);
                ans = Math.min(ans, A[i][j]+C*(i-j)+dp2[i][j]);
                dp2[i][j] = Math.min(dp2[i][j], A[i][j]-C*(i-j));
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
