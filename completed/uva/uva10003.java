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
        while(!(input = f.readLine()).equals("0")) {
            int l = Integer.parseInt(input);
            int n = Integer.parseInt(f.readLine());
            int[] c = new int[n+2];
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int i = 1; i <= n; i++) {
                c[i] = Integer.parseInt(st.nextToken());
            }
            c[n+1] = l;
            int[][] dp = new int[n+2][n+2];
            for(int d = 2; d < n+2; d++) {
                for(int i = 0; i < n+2-d; i++) {
                    int j = d + i;
                    int cutMin = Integer.MAX_VALUE;
                    for (int k = i + 1; k < j; k++)
                        cutMin = Math.min(cutMin,dp[i][k]+dp[k][j]);

                    dp[i][j] = cutMin+c[j]-c[i];
                }
            }
            out.println("The minimum cutting is " + dp[0][n+1] + ".");
        }
        f.close();
        out.close();
    }
}
