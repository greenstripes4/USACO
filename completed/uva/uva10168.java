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
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        linearSieve = new boolean[10000001];
        calculateLinearSieve();
        String input;
        while((input = f.readLine()) != null) {
            int N = Integer.parseInt(input);
            if(N < 8) {
                out.println("Impossible.");
            } else {
                if(N%2 == 1) {
                    out.print("2 3 ");
                    N -= 5;
                } else {
                    out.print("2 2 ");
                    N -= 4;
                }
                for(int i: compressedPrimes) {
                    if(!linearSieve[N-i]) {
                        out.println(i + " " + (N-i));
                        break;
                    }
                }
            }
        }
        f.close();
        out.close();
    }
}