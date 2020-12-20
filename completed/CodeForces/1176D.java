import java.io.*;
import java.math.BigInteger;
import java.net.CookiePolicy;
import java.util.*;

public class Main {
    private static int getLargestDivisor(int n) {
        for(int i = 2; i*i <= n; i++) {
            if(n%i == 0) {
                return n/i;
            }
        }
        return 1;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        boolean[] notPrime = new boolean[2750132];
        notPrime[0] = true;
        notPrime[1] = true;
        int[] pSequenceIndex = new int[2750132];
        pSequenceIndex[2] = 0;
        int lastPrime = 2;
        for(int i = 2; i < 2750132; i++) {
            if(!notPrime[i]) {
                pSequenceIndex[i] = pSequenceIndex[lastPrime]+1;
                lastPrime = i;
                for(int j = 2*i; j < 2750132; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        TreeMap<Integer, Integer> b = new TreeMap<>();
        for(int i = 0; i < 2*n; i++) {
            int bi = Integer.parseInt(st.nextToken());
            b.put(bi, b.getOrDefault(bi, 0)+1);
        }
        int[] a = new int[n];
        int indexA = 0;
        while(indexA < n) {
            int last = b.lastKey();
            int lastOccurances = b.get(last)-1;
            if(lastOccurances == 0) {
                b.remove(last);
            } else {
                b.put(last, lastOccurances);
            }
            if(notPrime[last]) {
                a[indexA++] = last;
                int largestDivisor = getLargestDivisor(last);
                int largestDivisorOccurances = b.get(largestDivisor)-1;
                if(largestDivisorOccurances == 0) {
                    b.remove(largestDivisor);
                } else {
                    b.put(largestDivisor, largestDivisorOccurances);
                }
            } else {
                a[indexA++] = pSequenceIndex[last];
                int indexOccurances = b.get(pSequenceIndex[last])-1;
                if(indexOccurances == 0) {
                    b.remove(pSequenceIndex[last]);
                } else {
                    b.put(pSequenceIndex[last], indexOccurances);
                }
            }
        }
        out.print(a[0]);
        for(int i = 1; i < n; i++) {
            out.print(" " + a[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}