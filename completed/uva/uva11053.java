import java.io.*;
import java.util.*;

public class Main {
    private static int move(long cur, long a, long b, long MOD) {
        return (int) (((((a*cur)%MOD)*cur)%MOD+b)%MOD);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            if(N == 0) {
                break;
            }
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int slow = 0;
            int fast = 0;
            do {
                slow = move(slow, a, b, N);
                fast = move(move(fast, a, b, N), a, b, N);
            } while(slow != fast);
            slow = 0;
            do {
                slow = move(slow, a, b, N);
                fast = move(fast, a, b, N);
            } while(slow != fast);
            int ans = N;
            do {
                slow = move(slow, a, b, N);
                ans--;
            } while(slow != fast);
            out.println(ans);
        }
        f.close();
        out.close();
    }
}
