import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int[][] map = new int[M][N];
            for(int i = 0; i < M; i++) {
                StringTokenizer line = new StringTokenizer(f.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(line.nextToken());
                }
            }
            int[][] dp = new int[M+1][N+1];
            for(int i = 1; i <= M; i++) {
                for(int j = 1; j <= N; j++) {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+map[i-1][j-1];
                }
            }
            int maxArea = 0;
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    for(int k = i; k < M; k++) {
                        for(int l = j; l < N; l++) {
                            if(dp[k+1][l+1]-dp[i][l+1]-dp[k+1][j]+dp[i][j] == 0) {
                                maxArea = Math.max(maxArea,(k-i+1)*(l-j+1));
                            }
                        }
                    }
                }
            }
            out.println(maxArea);
        }
        f.close();
        out.close();
    }
}
