import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long temp = (b*(b-1)/2)%1000000007;
        long ans = 0;
        for(long k = 1; k <= a; k++) {
            long cur = (k*b+1)%1000000007;
            ans = (ans+temp*cur)%1000000007;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}