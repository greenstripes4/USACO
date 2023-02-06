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
        BufferedReader f = new BufferedReader(new FileReader("circlecross.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));
        N = Integer.parseInt(f.readLine());
        int[] arr = new int[2*N];
        for(int i = 0; i < 2*N; i++) {
            arr[i] = Integer.parseInt(f.readLine());
        }
        BIT = new long[N+1];
        int[] time = new int[N+1];
        int t = 1;
        long ans = 0;
        for(int i: arr) {
            if(time[i] > 0) {
                ans -= query(time[i]-1);
                update(time[i], -1);
            } else {
                time[i] = t++;
                ans += query(time[i]-1);
                update(time[i], 1);
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
