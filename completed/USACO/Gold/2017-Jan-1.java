import java.io.*;
import java.util.*;

public class Main {
    private static int[] BIT;
    private static void update(int index, int add) {
        while(index < BIT.length) {
            BIT[index] += add;
            index += index&-index;
        }
    }
    private static int query(int index) {
        int sum = 0;
        while(index > 0) {
            sum += BIT[index];
            index -= index&-index;
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("bphoto.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bphoto.out")));
        int N = Integer.parseInt(f.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        int[] h = new int[N];
        for(int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(f.readLine());
            set.add(h[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = 1;
        for(int i: set) {
            map.put(i, n++);
        }
        for(int i = 0; i < N; i++) {
            h[i] = map.get(h[i]);
        }
        BIT = new int[n];
        int[] L = new int[N];
        for(int i = 0; i < N; i++) {
            L[i] = query(n-1)-query(h[i]);
            update(h[i], 1);
        }
        BIT = new int[n];
        int[] R = new int[N];
        for(int i = N-1; i >= 0; i--) {
            R[i] = query(n-1)-query(h[i]);
            update(h[i], 1);
        }
        int ans = 0;
        for(int i = 0; i < N; i++) {
            if(Math.min(L[i], R[i])*2 < Math.max(L[i], R[i])) {
                ans++;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
