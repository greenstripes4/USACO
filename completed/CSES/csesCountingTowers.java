import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long[] dp1 = new long[1000001];
        long[] dp2 = new long[1000001];
        dp1[1] = 1;
        dp2[1] = 1;
        for(int i = 2; i <= 1000000; i++) {
            dp1[i] = ((dp1[i-1]*4)%1000000007+dp2[i-1])%1000000007;
            dp2[i] = ((dp2[i-1]*2)%1000000007+dp1[i-1])%1000000007;
        }
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(f.readLine());
            out.println((dp1[n]+dp2[n])%1000000007);
        }
        f.close();
        out.close();
    }
}