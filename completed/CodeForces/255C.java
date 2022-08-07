import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        int[] b = new int[n];
        for(int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            set.add(b[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for(int i: set) {
            map.put(i, idx++);
        }
        for(int i = 0; i < n; i++) {
            b[i] = map.get(b[i]);
        }
        int[][] prev = new int[n][idx];
        Arrays.fill(prev[0], -1);
        prev[0][b[0]] = 0;
        for(int i = 1; i < n; i++) {
            Arrays.fill(prev[i], -1);
            for(int j = 0; j < idx; j++) {
                prev[i][j] = b[i] == j ? i : prev[i-1][j];
            }
        }
        int[][] dp = new int[n][idx];
        Arrays.fill(dp[0], 1);
        int ans = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < idx; j++) {
                if(prev[i-1][j] >= 0) {
                    dp[i][j] = dp[prev[i-1][j]][b[i]];
                }
                dp[i][j]++;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}