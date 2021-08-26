import java.io.*;
import java.util.*;

public class Main {
    private static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = gcd(a, b);
        TreeSet<Integer> factors = new TreeSet<>();
        for(int i = 1; i*i <= c; i++) {
            if(c%i == 0) {
                factors.add(i);
                factors.add(c/i);
            }
        }
        int n = Integer.parseInt(f.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            int low = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());
            Integer max = factors.floor(high);
            if(max == null || max < low) {
                out.println(-1);
            } else {
                out.println(max);
            }
        }
        f.close();
        out.close();
    }
}
