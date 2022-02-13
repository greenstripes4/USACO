import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            boolean flag = false;
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if(a[i] == k) {
                    flag = true;
                }
            }
            if(!flag) {
                out.println("no");
                continue;
            }
            flag = false;
            for(int i = 0; i < n-2; i++) {
                int cnt = 0;
                cnt += a[i] >= k ? 1 : 0;
                cnt += a[i+1] >= k ? 1 : 0;
                cnt += a[i+2] >= k ? 1 : 0;
                if(cnt >= 2) {
                    flag = true;
                    break;
                }
            }
            Arrays.sort(a);
            out.println(flag || k <= a[(n-1)/2] ? "yes" : "no");
        }
        f.close();
        out.close();
    }
}
