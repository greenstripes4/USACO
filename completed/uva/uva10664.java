import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int m = Integer.parseInt(f.readLine());
        for(int t = 0; t < m; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] luggage = new int[st.countTokens()];
            int i = 0;
            int sum = 0;
            while(st.hasMoreTokens()) {
                luggage[i] = Integer.parseInt(st.nextToken());
                sum += luggage[i++];
            }
            if(sum%2 != 0) {
                out.println("NO");
                continue;
            }
            int[][] dp = new int[luggage.length+1][sum/2+1];
            for(i = 1; i <= luggage.length; i++) {
                for(int j = 0; j <= sum/2; j++) {
                    if(luggage[i-1] <= j) {
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-luggage[i-1]]+luggage[i-1]);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            out.println(dp[luggage.length][sum/2] == sum/2 ? "YES" : "NO");
        }
        f.close();
        out.close();
    }
}
