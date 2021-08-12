import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] linearSieve;
    private static TreeSet<Integer> compressedPrimes;
    private static void calculateLinearSieve() {
        compressedPrimes = new TreeSet<>();
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
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        linearSieve = new boolean[100005];
        calculateLinearSieve();
        int[][] cost = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                cost[i][j] = compressedPrimes.ceiling(arr[i][j])-arr[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int cur = 0;
            for(int j = 0; j < m; j++) {
                cur += cost[i][j];
            }
            min = Math.min(min, cur);
        }
        for(int j = 0; j < m; j++) {
            int cur = 0;
            for(int i = 0; i < n; i++) {
                cur += cost[i][j];
            }
            min = Math.min(min, cur);
        }
        out.println(min);
        f.close();
        out.close();
    }
}
