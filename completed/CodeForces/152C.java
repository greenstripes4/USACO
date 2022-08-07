import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static final int MOD = 1000000007;
    private static int multiply(long a, long b) {
        return (int) (((a%MOD)*(b%MOD))%MOD);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<HashSet<Character>> arr = new ArrayList<>(m);
        for(int i = 0; i < m; i++) {
            arr.add(new HashSet<>());
        }
        for(int i = 0; i < n; i++) {
            char[] s = f.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                arr.get(j).add(s[j]);
            }
        }
        int ans = 1;
        for(HashSet<Character> i: arr) {
            ans = multiply(ans, i.size());
        }
        out.println(ans);
        f.close();
        out.close();
    }
}