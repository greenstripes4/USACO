import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[][] arr;
    private static int[] color;
    private static int val;
    private static double ans;
    private static void dfs(int i, int n) {
        if(i == n) {
            int a = 0;
            int b = 0;
            double p = 1;
            for(int j = 0; j < n; j++) {
                if(color[j] == 0) {
                    a++;
                    p *= Math.min(arr[j][1]-arr[j][0]+1, Math.max(0, arr[j][1]-val))/(double) (arr[j][1]-arr[j][0]+1);
                } else if(color[j] == 1) {
                    b++;
                    p *= ((val >= arr[j][0] && val <= arr[j][1]) ? 1 : 0)/(double) (arr[j][1]-arr[j][0]+1);
                } else {
                    p *= Math.min(arr[j][1]-arr[j][0]+1, Math.max(0, val-arr[j][0]))/(double) (arr[j][1]-arr[j][0]+1);
                }
            }
            if(b > 0 && a <= 1 && a+b >= 2) {
                ans += p*val;
            }
            return;
        }
        color[i] = 0;
        dfs(i+1, n);
        color[i] = 1;
        dfs(i+1, n);
        color[i] = 2;
        dfs(i+1, n);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        n = Integer.parseInt(f.readLine());
        arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        ans = 0;
        for(int i = 1; i <= 10000; i++) {
            color = new int[n];
            val = i;
            dfs(0, n);
        }
        out.println(ans);
        f.close();
        out.close();
    }
}