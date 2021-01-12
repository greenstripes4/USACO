import java.io.*;
import java.util.*;

public class Main {
    private static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int r = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(r > b) {
                r ^= b;
                b ^= r;
                r ^= b;
            }
            int kTemp = (b-1-gcd(r, b))/r+1;
            out.println(kTemp < k ? "OBEY" : "REBEL");
        }
        f.close();
        out.close();
    }
}
