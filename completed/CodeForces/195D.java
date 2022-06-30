import java.io.*;
import java.util.*;

public class Main {
    private static int gcd(int a, int b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        HashSet<String> res = new HashSet<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int k = Integer.parseInt(st.nextToken());
            int b = -Integer.parseInt(st.nextToken());
            if(k == 0) {
                continue;
            }
            if(k < 0) {
                k = -k;
                b = -b;
            }
            int gcd = gcd(k, Math.abs(b));
            k /= gcd;
            b /= gcd;
            res.add(b+"/"+k);
        }
        out.println(res.size());
        f.close();
        out.close();
    }
}