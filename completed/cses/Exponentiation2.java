import java.io.*;
import java.util.*;

public class Main {
    private static long pow(long a, long b) {
        if(b == 0) {
            return 1;
        }
        if(b%2 == 0) {
            long sqrt = pow(a, b/2)%1000000007;
            return (sqrt*sqrt)%1000000007;
        }
        long minusOneB = pow(a, b-1)%1000000007;
        return (minusOneB*a)%1000000007;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            out.println(pow(a, pow(b, c)));
        }
        f.close();
        out.close();
    }
}