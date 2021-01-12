import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[m];
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1-integer;
            }
        });
        int LIMIT = Math.min(n, m);
        long ans = 0;
        for(int i = 0; i < LIMIT && a[i] < b[i]; i++) {
            ans += b[i]-a[i];
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
