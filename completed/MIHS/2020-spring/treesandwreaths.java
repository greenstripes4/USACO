import java.io.*;
import java.util.*;

public class program {
    private static int solve(int N, int K) {
        if(N < K) {
            return 2*N-1;
        }
        return (int) Math.pow(2, N-K+3)+K-4;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        out.println(solve(N, K));
        f.close();
        out.close();
    }
}
