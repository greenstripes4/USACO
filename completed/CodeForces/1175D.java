import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Long> suff = new ArrayList<>();
        suff.add((long) a[n-1]);
        for(int i = n-2; i >= 0; i--) {
            suff.add(suff.get(suff.size()-1)+a[i]);
        }
        long ans = suff.get(n-1);
        suff.set(n-1, Long.MIN_VALUE);
        Collections.sort(suff);
        for(int i = n-1; i > n-k; i--) {
            ans += suff.get(i);
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
