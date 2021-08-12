import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans ^= Integer.parseInt(st.nextToken());
        }
        int[] xor = new int[n+1];
        for(int i = 1; i <= n; i++) {
            xor[i] = xor[i-1]^i;
        }
        for(int i = 2; i <= n; i++) {
            int repeats = n/i;
            int left = n%i;
            if(repeats%2 == 0) {
                ans ^= xor[left];
            } else {
                ans ^= xor[i-1]^xor[left];
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
