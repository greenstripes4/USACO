import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] linearSieve;
    private static void calculateLinearSieve() {
        ArrayList<Integer> compressedPrimes = new ArrayList<>();
        linearSieve[0] = true;
        linearSieve[1] = true;
        for(int i = 2; i < linearSieve.length; i++) {
            if(!linearSieve[i]) {
                compressedPrimes.add(i);
            }
            for(int j: compressedPrimes) {
                if(i*j >= linearSieve.length) {
                    break;
                }
                linearSieve[i*j] = true;
                if(i%j == 0) {
                    break;
                }
            }
        }
    }
    private static boolean isPalindrome(int x) {
        int y = 0;
        int temp = x;
        while(temp > 0) {
            y = y*10+temp%10;
            temp /= 10;
        }
        return x == y;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        linearSieve = new boolean[20000000];
        calculateLinearSieve();
        StringTokenizer st = new StringTokenizer(f.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        long primes = 0;
        long palindromes = 0;
        int n = 0;
        for(int i = 1; i < 20000000; i++) {
            if(!linearSieve[i]) {
                primes++;
            }
            if(isPalindrome(i)) {
                palindromes++;
            }
            if(primes*q <= palindromes*p) {
                n = i;
            }
        }
        out.println(n);
        f.close();
        out.close();
    }
}