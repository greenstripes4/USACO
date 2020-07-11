import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String a;
        while((a = f.readLine()) != null){
            String b = f.readLine();
            int[][] dp = new int[a.length()+1][b.length()+1];
            for(int i = 0; i < a.length(); i++){
                for(int j = 0; j < b.length(); j++){
                    if(a.charAt(i) == b.charAt(j)){
                        dp[i+1][j+1] = dp[i][j]+1;
                    } else {
                        dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                    }
                }
            }
            out.println(dp[a.length()][b.length()]);
        }
        f.close();
        out.close();
    }
}
