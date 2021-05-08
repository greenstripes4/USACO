import java.io.*;
import java.util.*;

public class Main {
    private static long f(int M, int N) {
        if(M == 0 || N == 1) {
            return 1;
        }
        if(M < N) {
            return f(M, M);
        }
        return f(M, N-1)+f(M-N, N);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = f.nextInt();
        while(t-- > 0) {
            int M = f.nextInt();
            int N = f.nextInt();
            out.println(f(M, N));
        }
        f.close();
        out.close();
    }
}
