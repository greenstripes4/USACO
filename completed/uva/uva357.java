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
        int[] coins = {1,5,10,25,50};
        long[] dp = new long[30001];
        dp[0] = 1;
        for(int c: coins){
            for(int i = 1; i < 30001; i++){
                if(i-c >= 0){
                    dp[i] += dp[i-c];
                }
            }
        }
        while((input = f.readLine()) != null){
            int n = Integer.parseInt(input);
            long m = dp[n];
            if(m == 1){
                out.println("There is only 1 way to produce " + n + " cents change.");
            } else {
                out.println("There are " + m + " ways to produce " + n + " cents change.");
            }
        }
        f.close();
        out.close();
    }
}
