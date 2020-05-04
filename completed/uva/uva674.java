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
        int[] dp = new int[7500];
        dp[0] = 1;
        for(int c: coins){
            for(int i = 1; i < 7500; i++){
                if(i-c >= 0){
                    dp[i] += dp[i-c];
                }
            }
        }
        while((input = f.readLine()) != null){
            out.println(dp[Integer.parseInt(input)]);
        }
        f.close();
        out.close();
    }
}
