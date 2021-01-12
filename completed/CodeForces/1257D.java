import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(f.readLine());
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(f.readLine());
            int[] c = new int[n+1];
            for(int j = 0; j < m; j++) {
                st = new StringTokenizer(f.readLine());
                int p = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                c[s] = Math.max(c[s], p);
            }
            for(int j = n-1; j >= 0; j--) {
                c[j] = Math.max(c[j], c[j+1]);
            }
            int k = 0;
            int d = 0;
            while(k < n) {
                int nextK = k;
                int max = 0;
                while(nextK < n) {
                    max = Math.max(max, a[nextK]);
                    if(c[nextK-k+1] < max) {
                        break;
                    }
                    nextK++;
                }
                if(nextK == k) {
                    break;
                }
                d++;
                k = nextK;
            }
            out.println(k == n ? d : -1);
        }
        f.close();
        out.close();
    }
}
