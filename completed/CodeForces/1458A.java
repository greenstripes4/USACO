import java.io.*;
import java.util.*;

public class Main {
    private static long gcd(long a, long b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        long[] a = new long[n];
        for(int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(a);
        st = new StringTokenizer(f.readLine());
        long[] b = new long[m];
        for(int i = 0; i < m; i++) {
            b[i] = Long.parseLong(st.nextToken());
        }
        long ans = 0;
        for(int i = 1; i < n; i++) {
            ans = gcd(ans, a[i]-a[0]);
        }
        out.print(gcd(ans, a[0]+b[0]));
        for(int i = 1; i < m; i++) {
            out.print(" " + gcd(ans, a[0]+b[i]));
        }
        out.println();
        f.close();
        out.close();
    }
}