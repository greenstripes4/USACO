import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        Long[] a = new Long[n];
        for(int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(a, Comparator.reverseOrder());
        for(int i = 1; i < n; i++) {
            a[i] += a[i-1];
        }
        long ans = 0;
        for(int i = 1; i <= n; i *= 4) {
            ans += a[i-1];
        }
        out.println(ans);
        f.close();
        out.close();
    }
}