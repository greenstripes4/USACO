import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] friends = new int[N][3];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            friends[i][0] = Integer.parseInt(st.nextToken());
            friends[i][1] = Integer.parseInt(st.nextToken());
            friends[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(friends, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2]-o1[2];
            }
        });
        int[][][] dp = new int[N+1][A+1][B+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= A; j++) {
                for(int k = 0; k <= B; k++) {
                    dp[i][j][k] = dp[i-1][j][k];
                    int discount = Math.min(friends[i-1][1], k/friends[i-1][2]);
                    if(j >= friends[i-1][1]-discount) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j-friends[i-1][1]+discount][k-discount*friends[i-1][2]]+friends[i-1][0]);
                    }
                }
            }
        }
        out.println(dp[N][A][B]);
        f.close();
        out.close();
    }
}
