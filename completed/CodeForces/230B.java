import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static boolean isPrime(int a) {
        if(a == 1) {
            return false;
        }
        for(int j = 2; j*j <= a; j++) {
            if(a%j == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            long x = Long.parseLong(st.nextToken());
            double sqrt = Math.sqrt(x);
            int floorSqrt = (int) sqrt;
            if(sqrt == floorSqrt && isPrime(floorSqrt)) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
        f.close();
        out.close();
    }
}
