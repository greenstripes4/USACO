import java.io.*;
import java.util.*;

public class Main {
    private static boolean valid(long N, long M, long K, long X) {
        while(N > 0) {
            if(K == 0) {
                return false;
            }
            if(N/X > M) {
                N -= N/X;
                K--;
            } else {
                N -= M*K;
                return N <= 0;
            }

        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("loan.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long low = 1;
        long high = N;
        long ans = -1;
        while(low <= high) {
            long mid = (low+high)/2;
            if(valid(N, M, K, mid)) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
