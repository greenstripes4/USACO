import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[] dp = new int[77];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        for(int i = 4; i < 77; i++) {
            dp[i] = dp[i-2]+dp[i-3];
        }
        while(f.hasNext()) {
            int n = f.nextInt();
            out.println(dp[n]);
        }
        f.close();
        out.close();
    }
}
