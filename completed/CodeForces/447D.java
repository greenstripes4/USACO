import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];
        int[] rowSum = new int[n];
        int[] colSum = new int[m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                rowSum[i] += a[i][j];
                colSum[j] += a[i][j];
            }
        }
        PriorityQueue<Long> rows = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Long> cols = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i: rowSum) {
            rows.offer((long) i);
        }
        for(int i: colSum) {
            cols.offer((long) i);
        }
        long[] pickedRows = new long[k+1];
        for(int i = 1; i <= k; i++) {
            long row = rows.poll();
            pickedRows[i] = pickedRows[i-1]+row;
            row -= p*m;
            rows.offer(row);
        }
        long[] pickedCols = new long[k+1];
        for(int i = 1; i <= k; i++) {
            long col = cols.poll();
            pickedCols[i] = pickedCols[i-1]+col;
            col -= p*n;
            cols.offer(col);
        }
        long ans = Long.MIN_VALUE;
        for(int i = 0; i <= k; i++) {
            ans = Math.max(ans, pickedRows[i]+pickedCols[k-i]-(long) p*i*(k-i));
        }
        out.println(ans);
        f.close();
        out.close();
    }
}