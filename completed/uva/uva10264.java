import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            int N = Integer.parseInt(input);
            long[] arr = new long[1 << N];
            for(int i = 0; i < (1 << N); i++) {
                arr[i] = Long.parseLong(f.readLine());
            }
            long[] p = new long[1 << N];
            for(int i = 0; i < (1 << N); i++) {
                long cur = 0;
                for(int j = 0; j < N; j++) {
                    cur += arr[i^(1 << j)];
                }
                p[i] = cur;
            }
            long ans = 0;
            for(int i = 0; i < (1 << N); i++) {
                for(int j = 0; j < N; j++) {
                    ans = Math.max(ans, p[i]+p[i^(1 << j)]);
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}