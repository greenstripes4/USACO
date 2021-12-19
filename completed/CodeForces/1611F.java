import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("cowjump.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            long[] a = new long[n+1];
            long cur = 0;
            for(int i = 1; i <= n; i++) {
                cur += Integer.parseInt(st.nextToken());
                a[i] = cur;
            }
            TreeMap<Long, Integer> occ = new TreeMap<>();
            int i = 1;
            int j = 1;
            int start = -1;
            int end = -1;
            int size = 0;
            while(j <= n+1) {
                if(occ.isEmpty() || s+occ.firstKey()-a[i-1] >= 0) {
                    if(j-i > size) {
                        start = i;
                        end = j-1;
                        size = j-i;
                    }
                    if(j == n+1) {
                        break;
                    }
                    occ.put(a[j], occ.getOrDefault(a[j], 0)+1);
                    j++;
                } else {
                    occ.put(a[i], occ.get(a[i])-1);
                    if(occ.get(a[i]) == 0) {
                        occ.remove(a[i]);
                    }
                    i++;
                }
            }
            if(size == 0) {
                out.println(-1);
            } else {
                out.println(start + " " + end);
            }
        }
        f.close();
        out.close();
    }
}
