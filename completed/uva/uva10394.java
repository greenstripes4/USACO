import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] linearSieve;
    private static ArrayList<Integer> compressedPrimes;
    private static ArrayList<int[]> twinPrimes;
    private static void calculateLinearSieve() {
        compressedPrimes = new ArrayList<>();
        twinPrimes = new ArrayList<>();
        linearSieve[0] = true;
        linearSieve[1] = true;
        for(int i = 2; i < linearSieve.length; i++) {
            if(!linearSieve[i]) {
                if(compressedPrimes.size() > 0 && compressedPrimes.get(compressedPrimes.size()-1) == i-2) {
                    twinPrimes.add(new int[]{compressedPrimes.get(compressedPrimes.size()-1), i});
                }
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
        linearSieve = new boolean[20000001];
        calculateLinearSieve();
        String input;
        while((input = f.readLine()) != null) {
            int n = Integer.parseInt(input);
            out.println("(" + twinPrimes.get(n-1)[0] + ", " + twinPrimes.get(n-1)[1] + ")");
        }
        f.close();
        out.close();
    }
}