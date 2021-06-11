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
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] mod1 = new int[a];
            for(int i = 0; i < a; i++) {
                mod1[i] = i%a%b;
            }
            int[] mod2 = new int[b];
            for(int i = 0; i < b; i++) {
                mod2[i] = i%b%a;
            }
            int lcm = a*b/gcd(a, b);
            int[] mod = new int[lcm+1];
            for(int i = 0; i < lcm; i++) {
                mod[i+1] = mod1[i%a] == mod2[i%b] ? 0 : 1;
            }
            for(int i = 1; i <= lcm; i++) {
                mod[i] += mod[i-1];
            }
            int q = Integer.parseInt(st.nextToken());
            long[] res = new long[q];
            for(int i = 0; i < q; i++) {
                st = new StringTokenizer(f.readLine());
                long l = Long.parseLong(st.nextToken());
                long r = Long.parseLong(st.nextToken());
                if(r-l < lcm) {
                    int ll = (int) (l%lcm);
                    int rr = (int) (r%lcm);
                    if(ll > rr) {
                        res[i] = mod[lcm]-mod[ll]+mod[rr+1];
                    } else {
                        res[i] = mod[rr+1]-mod[ll];
                    }
                    continue;
                }
                int temp1 = (int) (lcm-l%lcm);
                int temp2 = (int) (r%lcm+1);
                long ll = l+temp1;
                long rr = r-temp2;
                long ans = (rr-ll+1)/lcm*mod[lcm];
                ans += mod[lcm]-mod[lcm-temp1];
                ans += mod[temp2];
                res[i] = ans;
            }
            out.print(res[0]);
            for(int i = 1; i < q; i++) {
                out.print(" " + res[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}