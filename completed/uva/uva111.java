import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] correctOrder = new int[n];
        for(int i = 0; i < n; i++) {
            correctOrder[Integer.parseInt(st.nextToken())-1] = i+1;
        }
        String input;
        while((input = f.readLine()) != null) {
            st = new StringTokenizer(input);
            int[] currentOrder = new int[n];
            for(int i = 0; i < n; i++) {
                currentOrder[Integer.parseInt(st.nextToken())-1] = i+1;
            }
            int[][] dp = new int[n+1][n+1];
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    dp[i][j] = correctOrder[i-1] == currentOrder[j-1] ? Math.max(dp[i-1][j-1]+1,Math.max(dp[i-1][j],dp[i][j-1])) : Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
            out.println(dp[n][n]);
        }
        f.close();
        out.close();
    }
}
