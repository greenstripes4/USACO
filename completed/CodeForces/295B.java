import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[][] a = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] x = new int[n];
        for(int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken())-1;
        }
        boolean[] v = new boolean[n];
        long[] ans = new long[n];
        for(int k = n-1; k >= 0; k--) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    a[i][j] = Math.min(a[i][j], a[i][x[k]]+a[x[k]][j]);
                }
            }
            v[x[k]] = true;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(v[i] && v[j]) {
                        ans[k] += a[i][j];
                    }
                }
            }
        }
        out.print(ans[0]);
        for(int i = 1; i < n; i++) {
            out.print(" " + ans[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}