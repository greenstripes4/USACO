import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        double[] a = new double[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int occ = r/p-(l+p-1)/p+1;
            a[i] = ((double) occ)/(r-l+1);
        }
        double ans = 0;
        for(int i = 1; i < n; i++) {
            double temp = 1-(1-a[i])*(1-a[i-1]);
            ans += temp*2000;
        }
        double temp = 1-(1-a[0])*(1-a[n-1]);
        ans += temp*2000;
        out.println(ans);
        f.close();
        out.close();
    }
}
