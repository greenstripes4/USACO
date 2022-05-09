import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        int[] last = new int[200001];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            last[a[i]] = i;
        }
        HashMap<Integer, Integer> occ = new HashMap<>();
        int start = 0;
        int end = 0;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(i > end) {
                int max = 0;
                for(int j: occ.values()) {
                    max = Math.max(max, j);
                }
                ans += i-start-max;
                occ.clear();
                start = i;
            }
            occ.put(a[i], occ.getOrDefault(a[i], 0)+1);
            end = Math.max(end, last[a[i]]);
        }
        int max = 0;
        for(int j: occ.values()) {
            max = Math.max(max, j);
        }
        ans += n-start-max;
        out.println(ans);
        f.close();
        out.close();
    }
}
