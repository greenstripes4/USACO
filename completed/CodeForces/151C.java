import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] linearSieve;
    private static ArrayList<Integer> compressedPrimes;
    private static void calculateLinearSieve() {
        compressedPrimes = new ArrayList<>();
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
    private static long[] getPrimeFactorization2(long x) {
        long[] res = new long[2];
        res[0] = 1;
        int left = 2;
        for(int p: compressedPrimes) {
            if(p*p > x) {
                break;
            }
            int e = 0;
            while(x%p == 0) {
                e++;
                x /= p;
            }
            res[1] += e;
            if(e > 0 && left > 0) {
                res[0] *= p;
                left--;
                e--;
            }
            if(e > 0 && left > 0) {
                res[0] *= p;
                left--;
            }
        }
        if(x > 1) {
            res[1]++;
            if(left > 0) {
                res[0] *= x;
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long q = Long.parseLong(f.readLine());
        if(q == 1) {
            out.println(1);
            out.println(0);
        } else {
            linearSieve = new boolean[3200000];
            calculateLinearSieve();
            long[] temp = getPrimeFactorization2(q);
            if(temp[1] == 1) {
                out.println(1);
                out.println(0);
            } else if(temp[1] == 2) {
                out.println(2);
            } else {
                out.println(1);
                out.println(temp[0]);
            }
        }
        f.close();
        out.close();
    }
}