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
        while(true) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) {
                break;
            }
            int[] c = new int[n];
            int sum = 0;
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(f.readLine());
                for(int j = 0; j < m-1; j++) {
                    st.nextToken();
                }
                c[i] = Integer.parseInt(st.nextToken());
                sum += c[i];
            }
            for(int i = 0; i < n; i++) {
                int gcd = gcd(c[i], sum);
                int a = c[i]/gcd;
                int b = sum/gcd;
                out.println(a + " / " + b);
            }
        }
        f.close();
        out.close();
    }
}
