import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("threesum.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        long[][] count = new long[N][N];
        for(int i = 0; i < N-1; i++) {
            HashMap<Integer, Integer> occ = new HashMap<>();
            occ.put(-A[i+1], 1);
            for(int j = i+2; j < N; j++) {
                count[i][j] = occ.getOrDefault(A[i]+A[j], 0);
                occ.put(-A[j], occ.getOrDefault(-A[j], 0)+1);
            }
        }
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < N; j++) {
                count[i][j] += count[i-1][j];
            }
        }
        long[][] dp = new long[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = i+2; j < N; j++) {
                dp[i][j] = dp[i][j-1]+count[j][j]-(i == 0 ? 0 : count[i-1][j]);
            }
        }
        while(Q-- > 0) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            out.println(dp[a][b]);
        }
        f.close();
        out.close();
    }
}