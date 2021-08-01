import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[][] dp = new int[1001][1001];
        for(int i = 0; i <= 1000; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i <= 1000; i++) {
            for(int j = 1; j <= 1000; j++) {
                dp[i][j] = (dp[i-1][j-1]+dp[i-1][j])%1000000007;
            }
        }
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);
            int i = n-k;
            int occ = 0;
            for(int j: a) {
                if(j == a[i]) {
                    occ++;
                }
            }
            int j = i+1;
            while(j < n && a[j] == a[i]) {
                j++;
            }
            out.println(dp[occ][j-i]);
        }
        f.close();
        out.close();
    }
}
