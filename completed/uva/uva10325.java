import java.io.*;
import java.util.*;

public class Main {
    private static long gcd(long a, long b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] arr = new int[M];
            for(int i = 0; i < M; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long ans = 0;
            for(int i = 1; i < 1 << M; i++) {
                long lcm = 1;
                for(int j = 0; j < M; j++) {
                    if((i&(1 << j)) > 0) {
                        lcm = lcm*arr[j]/gcd(lcm, arr[j]);
                    }
                }
                if(Integer.bitCount(i)%2 == 0) {
                    ans -= N/lcm;
                } else {
                    ans += N/lcm;
                }
            }
            out.println(N-ans);
        }
        f.close();
        out.close();
    }
}