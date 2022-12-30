import java.io.*;
import java.util.*;

public class Main {
    private static int MOD;
    private static ArrayList<Integer> getPrimeFactorization1(int x) {
        ArrayList<Integer> primeFactorization = new ArrayList<>();
        for(int p = 2; p*p  <= x; p++) {
            int e = 0;
            while(x%p == 0) {
                e++;
                x /= p;
            }
            if(e > 0) {
                primeFactorization.add(p);
            }
        }
        if(x > 1) {
            primeFactorization.add(x);
        }
        return primeFactorization;
    }
    private static int multiply(long a, long b) {
        return (int) (((a%MOD)*(b%MOD))%MOD);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        MOD = 998244353;
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            int prev = a[0];
            int ans = 1;
            for(int i = 1; i < n; i++) {
                int cur = a[i];
                if(prev%cur > 0) {
                    ans = 0;
                    break;
                }
                ArrayList<Integer> primeFactorization = getPrimeFactorization1(prev/cur);
                int max = m/cur;
                int count = max;
                int k = primeFactorization.size();
                for(int s = 1; s < (1 << k); s++) {
                    int x = 1;
                    for(int j = 0; j < k; j++) {
                        if((s&(1 << j)) > 0) {
                            x *= primeFactorization.get(j);
                        }
                    }
                    if(Integer.bitCount(s)%2 == 0) {
                        count += max/x;
                    } else {
                        count -= max/x;
                    }
                }
                prev = cur;
                ans = multiply(ans, count);
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}