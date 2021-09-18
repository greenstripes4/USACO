import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = 1;
        String a;
        while((a = f.readLine()) != null) {
            String b = f.readLine();
            out.printf("%2s", t++);
            if(a.length() == 0 || b.length() == 0) {
                out.println(". Blank!");
            } else {
                a = a.replaceAll("[^a-zA-Z0-9]", " ");
                b = b.replaceAll("[^a-zA-Z0-9]", " ");
                String[] arr = a.split(" +");
                String[] brr = b.split(" +");
                int[][] dp = new int[arr.length+1][brr.length+1];
                for(int i = 1; i <= arr.length; i++) {
                    for(int j = 1; j <= brr.length; j++) {
                        if(arr[i-1].equals(brr[j-1])) {
                            dp[i][j] = dp[i-1][j-1]+1;
                        } else {
                            dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                        }
                    }
                }
                out.println(". Length of longest match: " + dp[arr.length][brr.length]);
            }
        }
        f.close();
        out.close();
    }
}