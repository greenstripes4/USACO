import java.io.*;
import java.util.*;

public class Main {
    private static int[] linearSieve;
    private static void calculateLinearSieve() {
        ArrayList<Integer> compressedPrimes = new ArrayList<>();
        linearSieve[0] = 1;
        linearSieve[1] = 1;
        for(int i = 2; i < linearSieve.length; i++) {
            if(linearSieve[i] == 0) {
                compressedPrimes.add(i);
                linearSieve[i] = i;
            }
            for(int j: compressedPrimes) {
                if(i*j >= linearSieve.length) {
                    break;
                }
                linearSieve[i*j] = j;
                if(i%j == 0) {
                    break;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        linearSieve = new int[10000001];
        calculateLinearSieve();
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                int e = 0;
                int last = 0;
                int ans = 1;
                while(a[i] > 1) {
                    int p = linearSieve[a[i]];
                    if(p == last) {
                        e++;
                    } else {
                        if(e%2 == 1) {
                            ans *= last;
                        }
                        last = p;
                        e = 1;
                    }
                    a[i] /= p;
                }
                if(e%2 == 1) {
                    ans *= last;
                }
                a[i] = ans;
            }
            HashSet<Integer> seen = new HashSet<>();
            int ans = 1;
            for(int i: a) {
                if(seen.contains(i)) {
                    seen.clear();
                    ans++;
                    seen.add(i);
                } else {
                    seen.add(i);
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}