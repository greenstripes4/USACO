import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] arr = f.readLine().substring(5).toCharArray();
        boolean[][] dp = new boolean[arr.length][2];
        if(arr.length >= 2) {
            dp[arr.length-2][0] = true;
            if(arr.length >= 3) {
                dp[arr.length-3][1] = true;
            }
        }
        for(int i = arr.length-4; i >= 0; i--) {
            if(arr[i] == arr[i+2] && arr[i+1] == arr[i+3]) {
                dp[i][0] = dp[i+2][1];
            } else {
                dp[i][0] = dp[i+2][0] || dp[i+2][1];
            }
            if(i <= arr.length-6 && arr[i] == arr[i+3] && arr[i+1] == arr[i+4] && arr[i+2] == arr[i+5]) {
                dp[i][1] = dp[i+3][0];
            } else {
                dp[i][1] = dp[i+3][0] || dp[i+3][1];
            }
        }
        TreeSet<String> res = new TreeSet<>();
        for(int i = 0; i < arr.length; i++) {
            if(dp[i][0]) {
                res.add(""+arr[i]+arr[i+1]);
            }
            if(dp[i][1]) {
                res.add(""+arr[i]+arr[i+1]+arr[i+2]);
            }
        }
        out.println(res.size());
        for(String i: res) {
            out.println(i);
        }
        f.close();
        out.close();
    }
}