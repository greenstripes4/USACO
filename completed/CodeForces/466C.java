import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(f.readLine());
        long sum = 0;
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            sum += a[i];
        }
        HashMap<Long, Integer> map = new HashMap<>();
        long cur = 0;
        long count = 0;
        for(int i = 0; i < n-1; i++) {
            cur += a[i];
            sum -= a[i];
            if(cur == 2*sum) {
                count += map.getOrDefault(sum, 0);
            }
            map.put(cur, map.getOrDefault(cur, 0)+1);
        }
        out.println(count);
        f.close();
        out.close();
    }
}
