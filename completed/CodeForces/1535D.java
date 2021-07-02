import java.io.*;
import java.util.*;

public class Main {
    private static int getPrimeFactorization1(int x) {
        int primeFactorization = 0;
        for(int p = 2; p*p  <= x; p++) {
            while(x%p == 0) {
                primeFactorization++;
                x /= p;
            }
        }
        if(x > 1) {
            primeFactorization++;
        }
        return primeFactorization;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            int min = a == b ? 0 : b%a == 0 ? 1 : 2;
            int max = getPrimeFactorization1(a)+getPrimeFactorization1(b);
            out.println((k >= min && k <= max) && ((k == 1 && min == 1) || (k != 1)) ? "YES" : "NO");
        }
        f.close();
        out.close();
    }
}