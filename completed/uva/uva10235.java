import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.ceil(Math.sqrt(n)); i++) {
            if (n % i == 0 && i != n) {
                return false;
            }
        }
        return true;
    }

    public static int reverse(int n) {
        int result = 0;
        while (n != 0) {
            result = result * 10 + n % 10;
            n /= 10;
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while ((input = f.readLine()) != null) {
            int n = Integer.parseInt(input);
            if (!isPrime(n)) {
                out.println(n + " is not prime.");
            } else if (isPrime(reverse(n)) && reverse(n) != n) {
                out.println(n + " is emirp.");
            } else {
                out.println(n + " is prime.");
            }
        }
        f.close();
        out.close();
    }
}
