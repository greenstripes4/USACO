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
        BufferedReader f = new BufferedReader(new FileReader("haircut.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haircut.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        ArrayList<ArrayList<Integer>> indexes = new ArrayList<>(N+2);
        for(int i = 0; i < N+2; i++) {
            indexes.add(new ArrayList<>());
        }
        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken())+1;
            indexes.get(A[i]).add(i);
        }
        BIT = new int[N+2];
        int[] count = new int[N];
        long ans = 0;
        for(int i = 0; i < N; i++) {
            count[i] = query(N+1)-query(A[i]);
            ans += count[i];
            update(A[i], 1);
        }
        long[] res = new long[N+1];
        for(int i = N; i > 0; i--) {
            for(int j: indexes.get(i)) {
                ans -= count[j];
            }
            res[i] = ans;
        }
        for(int i = 1; i <= N; i++) {
            out.println(res[i]);
        }
        f.close();
        out.close();
    }
}