import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][3];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        int[][] dp1 = new int[N+1][B+1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= B; j++) {
                dp1[i][j] = dp1[i-1][j];
                if(arr[i-1][1]*arr[i-1][2] <= j) {
                    dp1[i][j] = Math.max(dp1[i][j], dp1[i-1][j-arr[i-1][1]*arr[i-1][2]]+arr[i-1][0]);
                }
            }
        }
        int[][] dp2 = new int[N+1][A+1];
        for(int i = N-1; i >= 0; i--) {
            for(int j = 1; j <= A; j++) {
                dp2[i][j] = dp2[i+1][j];
                if(arr[i][1] <= j) {
                    dp2[i][j] = Math.max(dp2[i][j], dp2[i+1][j-arr[i][1]]+arr[i][0]);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j <= arr[i][1]; j++) {
                int k = (arr[i][1]-j)*arr[i][2];
                if(j > A || k > B) {
                    continue;
                }
                max = Math.max(max, dp1[i][B-k]+dp2[i+1][A-j]+arr[i][0]);
            }
        }
        out.println(max);
        f.close();
        out.close();
    }
}
