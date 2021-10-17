import java.io.*;
import java.util.*;

public class Main {
    private static long[] BIT;
    private static void update(int index, int add) {
        while(index < BIT.length) {
            BIT[index] += add;
            index += index&-index;
        }
    }
    private static long query(int index) {
        long sum = 0;
        while(index > 0) {
            sum += BIT[index];
            index -= index&-index;
        }
        return sum;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            set.add(a[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 1;
        for(int i: set) {
            map.put(i, idx++);
        }
        for(int i = 0; i < n; i++) {
            a[i] = map.get(a[i]);
        }
        BIT = new long[idx+1];
        long[] left = new long[n];
        for(int i = 0; i < n; i++) {
            left[i] = query(idx)-query(a[i]);
            update(a[i], 1);
        }
        BIT = new long[idx+1];
        long ans = 0;
        for(int i = n-1; i >= 0; i--) {
            long right = query(a[i]-1);
            update(a[i], 1);
            ans += left[i]*right;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
