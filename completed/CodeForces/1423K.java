import java.io.*;
import java.util.*;

public class Main {
    private static int[] linearSieve;
    private static ArrayList<Integer> compressedPrimes;
    private static void calculateLinearSieve() {
        linearSieve = new int[1000001];
        Arrays.fill(linearSieve, 1);
        linearSieve[0] = 0;
        linearSieve[1] = 0;
        compressedPrimes = new ArrayList<>();
        for(int i = 2; i < linearSieve.length; i++) {
            if(linearSieve[i] > 0) {
                compressedPrimes.add(i);
            }
            for(int j: compressedPrimes) {
                if(i*j >= linearSieve.length) {
                    break;
                }
                linearSieve[i*j] = 0;
                if(i%j == 0) {
                    break;
                }
            }
        }
        for(int i = 1; i < linearSieve.length; i++) {
            linearSieve[i] += linearSieve[i-1];
        }
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        calculateLinearSieve();
        int t = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(st.nextToken());
            out.println(linearSieve[n]-linearSieve[(int) (Math.sqrt(n))]+1);
        }
        f.close();
        out.close();
    }
}