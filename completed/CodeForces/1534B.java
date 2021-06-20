import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            long ans = 0;
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if(i > 0) {
                    ans += Math.abs(a[i]-a[i-1]);
                } else {
                    ans += a[0];
                }
                if(i == n-1) {
                    ans += a[n-1];
                }
            }
            for(int i = 0; i < n; i++) {
                int left = i == 0 ? 0 : a[i-1];
                int right = i == n-1 ? 0 : a[i+1];
                int next = Math.max(left, right);
                if(a[i] <= next) {
                    continue;
                }
                ans -= a[i]-next;
                a[i] = next;
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}