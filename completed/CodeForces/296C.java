import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        long[] a = new long[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[][] operations = new int[m][3];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            operations[i][0] = Integer.parseInt(st.nextToken())-1;
            operations[i][1] = Integer.parseInt(st.nextToken())-1;
            operations[i][2] = Integer.parseInt(st.nextToken());
        }
        long[] diff = new long[m];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            diff[x]++;
            if(y+1 < m) {
                diff[y+1]--;
            }
        }
        for(int i = 1; i < m; i++) {
            diff[i] += diff[i-1];
        }
        long[] diff2 = new long[n];
        for(int i = 0; i < m; i++) {
            diff2[operations[i][0]] += operations[i][2]*diff[i];
            if(operations[i][1]+1 < n) {
                diff2[operations[i][1]+1] -= operations[i][2]*diff[i];
            }
        }
        out.print(a[0]+diff2[0]);
        for(int i = 1; i < n; i++) {
            diff2[i] += diff2[i-1];
            out.print(" " + (a[i]+diff2[i]));
        }
        out.println();
        f.close();
        out.close();
    }
}