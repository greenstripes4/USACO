import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N;
        while((N = f.nextInt()) != 0){
            int[] arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = f.nextInt();
            }
            int[] dp = new int[N];
            int sum = Math.max(arr[0],0);
            for(int i = 1; i < N; i++){
                sum += arr[i];
                if(sum < 0){
                    sum = 0;
                    dp[i] = 0;
                } else {
                    dp[i] = sum;
                }
            }
            int max = 0;
            for(int i = 0; i < N; i++){
                max = Math.max(max,dp[i]);
            }
            out.println(max == 0 ? "Losing streak." : "The maximum winning streak is " + max + ".");
        }
        f.close();
        out.close();
    }
}
