import java.io.*;
import java.util.*;

public class Main {
    private static int gcd(int a, int b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int gcd = gcd(a, b);
        a /= gcd;
        b /= gcd;
        int ans = 0;
        while(a%2 == 0) {
            ans++;
            a /= 2;
        }
        while(a%3 == 0) {
            ans++;
            a /= 3;
        }
        while(a%5 == 0) {
            ans++;
            a /= 5;
        }
        while(b%2 == 0) {
            ans++;
            b /= 2;
        }
        while(b%3 == 0) {
            ans++;
            b /= 3;
        }
        while(b%5 == 0) {
            ans++;
            b /= 5;
        }
        if(a > 1 || b > 1) {
            out.println(-1);
        } else {
            out.println(ans);
        }
        f.close();
        out.close();
    }
}