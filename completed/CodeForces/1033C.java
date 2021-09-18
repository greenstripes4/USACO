import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        Integer[] b = new Integer[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = i;
        }
        Arrays.sort(b, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return a[t1]-a[integer];
            }
        });
        char[] dp = new char[n];
        for(int i: b) {
            int start = i%a[i];
            boolean found = false;
            for(int j = start; j < n; j += a[i]) {
                if(a[j] > a[i] && dp[j] == 'B') {
                    found = true;
                    break;
                }
            }
            dp[i] = found ? 'A' : 'B';
        }
        out.println(dp);
        f.close();
        out.close();
    }
}