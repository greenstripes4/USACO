import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        BigInteger[] dp = new BigInteger[1001];
        dp[0] = BigInteger.valueOf(1);
        dp[1] = BigInteger.valueOf(2);
        dp[2] = BigInteger.valueOf(5);
        for(int i = 3; i <= 1000; i++) {
            dp[i] = dp[i-3].add(dp[i-2]).add(dp[i-1]).add(dp[i-1]);
        }
        String input;
        while((input = f.readLine()) != null) {
            out.println(dp[Integer.parseInt(input)]);
        }
        f.close();
        out.close();
    }
}