import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int[] P = new int[N];
            st = new StringTokenizer(f.readLine());
            for(int i = 0; i < N; i++) {
                P[N-i-1] = Integer.parseInt(st.nextToken());
            }
            LinkedList<Integer>[] dp = new LinkedList[S+1];
            dp[0] = new LinkedList<>();
            for(int i = 1; i <= S; i++) {
                LinkedList<Integer> min = null;
                for(int j: P) {
                    if(i-j >= 0 && dp[i-j] != null && (min == null || dp[i-j].size()+1 < min.size())) {
                        min = new LinkedList<>(dp[i-j]);
                        min.add(j);
                    }
                }
                dp[i] = min;
            }
            if(dp[S] == null) {
                out.println("Case " + t + ": impossible");
            } else {
                out.print("Case " + t + ": [" + dp[S].size() + "]");
                Collections.sort(dp[S], new Comparator<Integer>() {
                    @Override
                    public int compare(Integer integer, Integer t1) {
                        return t1-integer;
                    }
                });
                for(int i: dp[S]) {
                    out.print(" " + i);
                }
                out.println();
            }
        }
        f.close();
        out.close();
    }
}
