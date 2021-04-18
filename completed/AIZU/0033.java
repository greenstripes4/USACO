import java.io.*;
import java.util.*;

public class Main {
    private static boolean solve(int[] arr, int idx, int left, int right) {
        if(idx == 10) {
            return true;
        }
        if(arr[idx] > left && solve(arr, idx+1, arr[idx], right)) {
            return true;
        }
        if(arr[idx] > right && solve(arr, idx+1, left, arr[idx])) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        for(int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] arr = new int[10];
            for(int i = 0; i < 10; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            out.println(solve(arr, 0, 0, 0) ? "YES" : "NO");
        }
        f.close();
        out.close();
    }
}