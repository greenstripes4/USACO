import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        long[] x = new long[n+1];
        st = new StringTokenizer(f.readLine());
        for(int i = 1; i <= n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 2; i <= n; i++) {
            x[i] += x[i-1];
        }
        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(0L, 1);
        long max = Long.MIN_VALUE;
        for(int i = a; i <= n; i++) {
            max = Math.max(max, x[i]-map.firstKey());
            map.put(x[i-a+1], map.getOrDefault(x[i-a+1], 0)+1);
            if(i-b >= 0) {
                map.put(x[i-b], map.get(x[i-b])-1);
                if (map.get(x[i-b]) == 0) {
                    map.remove(x[i-b]);
                }
            }
        }
        out.println(max);
        f.close();
        out.close();
    }
}
