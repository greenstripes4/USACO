import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        ArrayList<Integer> occ = new ArrayList<>();
        ArrayList<Integer> emp = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(Integer.parseInt(st.nextToken()) == 1) {
                occ.add(i);
            } else {
                emp.add(i);
            }
        }
        long[][] dp = new long[emp.size()+1][occ.size()+1];
        for(long[] i: dp) {
            Arrays.fill(i, 25000000);
        }
        for(int i = 0; i <= emp.size(); i++) {
            dp[i][0] = 0;
        }
        for(int i = 1; i <= emp.size(); i++) {
            for(int j = 1; j <= occ.size(); j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]+Math.abs(occ.get(j-1)-emp.get(i-1)));
            }
        }
        out.println(dp[emp.size()][occ.size()]);
        f.close();
        out.close();
    }
}
