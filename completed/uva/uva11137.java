import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[] coins = {1,8,27,64,125,216,343,512,729,1000,1331,1728,2197,2744,3375,4096,4913,5832,6859,8000,9261};
        long[] dp = new long[10001];
        dp[0] = 1;
        for(int c: coins){
            for(int i = 1; i < 10001; i++){
                if(i-c >= 0){
                    dp[i] += dp[i-c];
                }
            }
        }
        while(f.hasNext()){
            int n = f.nextInt();
            out.println(dp[n]);
        }
        f.close();
        out.close();
    }
}
