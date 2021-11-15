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
        public static void main(String[] args) throws IOException{
                //BufferedReader f = new BufferedReader(new FileReader("cowjump.in"));
                BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
                //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
                linearSieve = new boolean[20001];
                calculateLinearSieve();
                int t = Integer.parseInt(f.readLine());
                while(t-- > 0) {
                        int n = Integer.parseInt(f.readLine());
                        StringTokenizer st = new StringTokenizer(f.readLine());
                        int[] a = new int[n];
                        int sum = 0;
                        for(int i = 0; i < n; i++) {
                                a[i] = Integer.parseInt(st.nextToken());
                                sum += a[i];
                        }
                        if(!linearSieve[sum]) {
                                out.println(n-1);
                                boolean flag = false;
                                boolean first = true;
                                for(int i = 1; i <= n; i++) {
                                        if(!flag && a[i-1]%2 == 1) {
                                                flag = true;
                                        } else {
                                                if(first) {
                                                        out.print(i);
                                                        first = false;
                                                } else {
                                                        out.print(" " + i);
                                                }
                                        }
                                }
                                out.println();
                        } else {
                                out.println(n);
                                out.print(1);
                                for(int i = 2; i <= n; i++) {
                                        out.print(" " + i);
                                }
                                out.println();
                        }
                }
                f.close();
                out.close();
    }
}
