import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] adjacencyMatrix = new int[n][n];
            for(int[] i: adjacencyMatrix) {
                Arrays.fill(i, Integer.MAX_VALUE/2);
            }
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(f.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                int c = Integer.parseInt(st.nextToken());
                adjacencyMatrix[a][b] = adjacencyMatrix[b][a] = Math.min(adjacencyMatrix[a][b], c);
            }
            int[] pow = new int[n+1];
            pow[0] = 1;
            for(int i = 1; i <= n; i++) {
                pow[i] = pow[i-1]*3;
            }
            int[][] dp = new int[pow[n]][n];
            for(int[] i: dp) {
                Arrays.fill(i, Integer.MAX_VALUE/2);
            }
            for(int i = 0; i < n; i++) {
                dp[pow[i]][i] = 0;
            }
            int min = Integer.MAX_VALUE/2;
            for(int i = 1; i < pow[n]; i++) {
                boolean flag = false;
                for(int j = 0; j < n; j++) {
                    if((i/pow[j])%3 > 0) {
                        for(int k = 0; k < n; k++) {
                            if((i/pow[k])%3 > 0) {
                                dp[i][j] = Math.min(dp[i][j], dp[i-pow[j]][k]+adjacencyMatrix[k][j]);
                            }
                        }
                    } else {
                        flag = true;
                    }
                }
                if(!flag) {
                    for(int j = 0; j < n; j++) {
                        min = Math.min(min, dp[i][j]);
                    }
                }
            }
            out.println(min == Integer.MAX_VALUE/2 ? -1 : min);
        }
        f.close();
        out.close();
    }
}