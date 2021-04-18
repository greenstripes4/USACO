import java.io.*;
import java.util.*;

public class Main {
    private static int helper(int[] arr, int K) {
        int[] turn = new int[arr.length];
        int temp = 0;
        for(int i = 0; i <= arr.length-K; i++) {
            if(i >= K) {
                temp -= turn[i-K];
            }
            if(temp%2 != arr[i]%2) {
                turn[i] = 1;
                temp++;
            }
        }
        for(int i = arr.length-K+1; i < arr.length; i++) {
            if(i >= K) {
                temp -= turn[i-K];
            }
            if(temp%2 != arr[i]%2) {
                return Integer.MAX_VALUE;
            }
        }
        int ans = 0;
        for(int i: turn) {
            if(i == 1) {
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = f.readLine().equals("F") ? 0 : 1;
        }
        int K = 0;
        int M = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            int temp = helper(arr, i);
            if(temp < M) {
                K = i;
                M = temp;
            }
        }
        out.println(K + " " + M);
        f.close();
        out.close();
    }
}
