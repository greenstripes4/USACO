import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[][] dp = new int[101][101];
        for(int i = 0; i <= 100; i++) {
            dp[0][i] = 1;
        }
        for(int i = 1; i <= 100; i++) {
            for(int j = 1; j <= 100; j++) {
                for(int k = 0; k <= i; k++) {
                    dp[i][j] = (dp[i][j]+dp[k][j-1])%1000000;
                }
            }
        }
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            out.println(dp[N][K]);
        }
        f.close();
        out.close();
    }
}
