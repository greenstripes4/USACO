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
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        if(k > 50) {
            out.println("NO");
        } else {
            HashSet<Long> set = new HashSet<>();
            for(int i = 1; i <= k; i++) {
                set.add(n%i);
            }
            out.println(set.size() == k ? "YES" : "NO");
        }
        f.close();
        out.close();
    }
}