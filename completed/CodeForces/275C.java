import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
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
        Arrays.sort(a);
        HashMap<Integer, Integer> subsequences = new HashMap<>();
        for(int i: a) {
            if(i%k == 0 && subsequences.containsKey(i/k)) {
                subsequences.put(i, subsequences.get(i/k)+1);
                subsequences.remove(i/k);
            } else {
                subsequences.put(i, 1);
            }
        }
        int ans = 0;
        for(int i: subsequences.values()) {
            ans += i-i/2;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
