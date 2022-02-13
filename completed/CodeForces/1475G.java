import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] modifiedSieve;
    private static void calculateSieve() {
        for(int i = 1; i < modifiedSieve.length; i++) {
            modifiedSieve[i] = new ArrayList<>();
        }
        for(int i = 1; i < modifiedSieve.length; i++) {
            for(int j = i; j < modifiedSieve.length; j += i) {
                modifiedSieve[j].add(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        modifiedSieve = new ArrayList[200001];
        calculateSieve();
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            ArrayList<Integer> a = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                a.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(a);
            int[] map = new int[200001];
            int ans = 0;
            for(int i: a) {
                int max = 1;
                for(int j: modifiedSieve[i]) {
                    max = Math.max(max, map[j]+1);
                }
                map[i] = Math.max(map[i], max);
                ans = Math.max(ans, max);
            }
            out.println(n-ans);
        }
        f.close();
        out.close();
    }
}
