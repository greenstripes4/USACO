import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int[] dp = new int[t+1];
            for(int i = 1; i <= t; i++) {
                int a = -1000000;
                int b = -1000000;
                if(i-m >= 0) {
                    a = 1+dp[i-m];
                }
                if(i-n >= 0) {
                    b = 1+dp[i-n];
                }
                dp[i] = Math.max(a,b);
            }
            for(int i = t; i >= 0; i--) {
                if(dp[i] >= 0) {
                    out.print(dp[i]);
                    if(t-i > 0) {
                        out.println(" " + (t-i));
                    } else {
                        out.println();
                    }
                    break;
                }
            }
        }
        f.close();
        out.close();
    }
}