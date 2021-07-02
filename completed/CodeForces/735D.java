import java.io.*;
import java.util.*;

public class Main {
    private static boolean isPrime(int x) {
        if(x == 1) {
            return false;
        }
        for(int p = 2; p*p <= x; p++) {
            if(x%p == 0) {
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
        if(isPrime(n)) {
            out.println(1);
        } else if(n%2 == 0 || isPrime(n-2)) {
            out.println(2);
        } else {
            out.println(3);

        }
        f.close();
        out.close();
    }
}