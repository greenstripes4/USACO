import java.io.*;
import java.util.*;

public class Main {
    private static double power(double a, int b) {
        double c = 1;
        while(b > 0) {
            if((b&1) > 0) {
                c *= a;
            }
            a *= a;
            b >>= 1;
        }
        return c;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int T = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        double[][] C = new double[T][T];
        C[0][0] = 1;
        for(int i = 1; i < T; i++) {
            C[i][0] = 1;
            for(int j = 1; j < T; j++) {
                C[i][j] = C[i-1][j-1]+C[i-1][j];
            }
        }
        double[] b = new double[T];
        for(int i = 0; i < T; i++) {
            b[i] = C[T-1][i]/power(2, T-1);
        }
        double[] a = new double[T];
        for(int i = 1; i < T; i++) {
            a[i] = b[i]*i+a[i-1];
            b[i] += b[i-1];
        }
        int idx = 1;
        double ans = a[T-1];
        while(idx < K) {
            int low = 1;
            int high = K-idx;
            int steps = high;
            double x = a[T-1]-a[(int) ans];
            double y = b[(int) ans];
            double z = power(y, high);
            double next = (x-x*z)/(1-y)+z*ans;
            while(low <= high) {
                int mid = (low+high)/2;
                x = a[T-1]-a[(int) ans];
                y = b[(int) ans];
                z = power(y, mid);
                double temp = (x-x*z)/(1-y)+z*ans;
                if((int) temp > (int) ans) {
                    high = mid-1;
                    steps = mid;
                    next = temp;
                } else {
                    low = mid+1;
                }
            }
            idx += steps;
            ans = next;
        }
        out.println(ans+1);
        f.close();
        out.close();
    }
}
