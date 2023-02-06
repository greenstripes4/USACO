import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static long[] BIT;
    private static void update(int index, int add) {
        while(index <= N) {
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
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        N = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] A = new int[N];
        Integer[] idx = new Integer[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            idx[i] = i;
        }
        st = new StringTokenizer(f.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        int[] B = new int[N];
        for(int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            set.add(B[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int x = 1;
        for(int i: set) {
            map.put(i, x++);
        }
        HashMap<String, Integer> occ = new HashMap<>();
        for(int i = 0; i < N; i++) {
            B[i] = map.get(B[i]);
            String temp = A[i] + " " + B[i];
            occ.put(temp, occ.getOrDefault(temp, 0)+1);
        }
        Arrays.sort(idx, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(A[o1] == A[o2]) {
                    return B[o2]-B[o1];
                }
                return A[o1]-A[o2];
            }
        });
        BIT = new long[N+1];
        long ans = 0;
        for(int i = 0; i < N; i++) {
            update(B[idx[i]], 1);
            ans += query(N)-query(B[idx[i]]-1);
        }
        for(int i: occ.values()) {
            ans += (long) i*i-(long) i*(i+1)/2;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
