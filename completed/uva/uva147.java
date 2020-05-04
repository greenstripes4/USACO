import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[] coins = {5,10,20,50,100,200,500,1000,2000,5000,10000};
        long[] dp = new long[30001];
        dp[0] = 1;
        for(int c: coins){
            for(int i = 1; i < 30001; i++){
                if(i-c >= 0){
                    dp[i] += dp[i-c];
                }
            }
        }
        while(true){
            int amount = Integer.parseInt(f.next().replace(".",""));
            if(amount == 0){
                break;
            }
            out.printf("%1$6s",String.format("%.2f",amount/100.0));
            out.printf("%1$17s",dp[amount]);
            out.println();
        }
        f.close();
        out.close();
    }
}
