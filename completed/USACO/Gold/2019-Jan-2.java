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
        BufferedReader f = new BufferedReader(new FileReader("sleepy.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
        int N = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] p = new int[N];
        for(int i = 0; i < N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        BIT = new int[N+1];
        int K = N-1;
        while(K > 0 && p[K-1] < p[K]) {
            update(p[K], 1);
            K--;
        }
        update(p[K], 1);
        int[] res = new int[K];
        for(int i = 0; i < K; i++) {
            res[i] = K-i-1+query(p[i]);
            update(p[i], 1);
        }
        out.println(K);
        out.print(res[0]);
        for(int i = 1; i < K; i++) {
            out.print(" " + res[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}