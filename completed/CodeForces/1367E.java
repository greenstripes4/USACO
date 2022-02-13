import java.io.*;
import java.util.*;

public class Main {
    private static int gcd(int a, int b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
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
            char[] s = f.readLine().toCharArray();
            int[] occ = new int[26];
            for(char i: s) {
                occ[i-'a']++;
            }
            int max = 0;
            for(int i: occ) {
                max = Math.max(max, i);
            }
            for(int i = max+1; i <= n; i++) {
                int l = k%i;
                if(l == 0) {
                    max = i;
                    continue;
                }
                l = gcd(l, i);
                int seg = i/l;
                int sum = 0;
                for(int j: occ) {
                    sum += j/seg;
                }
                if(sum >= l) {
                    max = i;
                }
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}
