import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = f.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = f.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            dp[i] = map.getOrDefault(a[i]-1, 0)+1;
            map.put(a[i], dp[i]);
            if(dp[i] > dp[max]) {
                max = i;
            }
        }
        int[] res = new int[dp[max]];
        int prev = max;
        for(int i = dp[max]-1; i >= 0; i--) {
            res[i] = prev+1;
            int next = prev-1;
            while(next >= 0 && a[next] != a[prev]-1) {
                next--;
            }
            prev = next;
        }
        out.println(dp[max]);
        out.print(res[0]);
        for(int i = 1; i < dp[max]; i++) {
            out.print(" " + res[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}