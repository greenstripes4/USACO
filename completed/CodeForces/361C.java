import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] queries = new int[m][4];
        int[] a = new int[n];
        int[] b = new int[n];
        Arrays.fill(b, 1000000000);
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken())-1;
            queries[i][2] = Integer.parseInt(st.nextToken())-1;
            queries[i][3] = Integer.parseInt(st.nextToken());
            if(queries[i][0] == 1) {
                for(int j = queries[i][1]; j <= queries[i][2]; j++) {
                    a[j] += queries[i][3];
                }
            } else {
                for(int j = queries[i][1]; j <= queries[i][2]; j++) {
                    b[j] = Math.min(b[j], queries[i][3]-a[j]);
                }
            }
        }
        a = b.clone();
        boolean flag = false;
        for(int i = 0; i < m; i++) {
            if(queries[i][0] == 1) {
                for(int j = queries[i][1]; j <= queries[i][2]; j++) {
                    b[j] += queries[i][3];
                }
            } else {
                int max = Integer.MIN_VALUE;
                for(int j = queries[i][1]; j <= queries[i][2]; j++) {
                    max = Math.max(max, b[j]);
                }
                if(max != queries[i][3]) {
                    flag = true;
                    break;
                }
            }
        }
        if(flag) {
            out.println("NO");
        } else {
            out.println("YES");
            out.print(a[0]);
            for(int i = 1; i < n; i++) {
                out.print(" " + a[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}