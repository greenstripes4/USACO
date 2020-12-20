import java.io.*;
import java.util.*;

public class Main {
    private static boolean isPrime(int n) {
        if(n == 1) {
            return false;
        }
        for(int i = 2; i*i <= n; i++) {
            if(n%i == 0) {
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
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(f.readLine());
            if(n == 1) {
                out.println("FastestFinger");
            } else if(n == 2) {
                out.println("Ashishgup");
            } else if(n%2 == 1) {
                out.println("Ashishgup");
            } else if(isPrime(n/2)) {
                out.println("FastestFinger");
            } else if((n&(n-1)) == 0) {
                out.println("FastestFinger");
            } else {
                out.println("Ashishgup");
            }
        }
        f.close();
        out.close();
    }
}
