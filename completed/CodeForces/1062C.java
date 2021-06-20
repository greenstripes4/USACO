import java.io.*;
import java.util.*;

public class Main {
    private static final int MOD = 1000000007;
    private static int add(long a, long b) {
        return (int) ((a%MOD+b%MOD)%MOD);
    }
    private static int subtract(long a, long b) {
        return add(a, -b);
    }
    private static int multiply(long a, long b) {
        return (int) ((a%MOD*b%MOD)%MOD);
    }
    private static int power(long a, long b) {
        long c = 1;
        while(b > 0) {
            if((b&1) > 0) {
                c = multiply(c, a);
            }
            a = multiply(a, a);
            b >>= 1;
        }
        return (int) c;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] prefixSum = new int[n+1];
        char[] s = f.readLine().toCharArray();
        for(int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i-1]+(s[i-1] == '1' ? 1 : 0);
        }
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(f.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            out.println(multiply(subtract(power(2, prefixSum[r]-prefixSum[l-1]), 1), power(2, r-l-prefixSum[r]+prefixSum[l-1]+1)));
        }
        f.close();
        out.close();
    }
}