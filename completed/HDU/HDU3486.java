import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[] arr;
    private static int[][] sparseTable;
    private static int[] log;
    private static void build() {
        log = new int[n+1];
        for(int i = 2; i <= n; i++) {
            log[i] = log[i/2]+1;
        }
        int m = 0;
        while((1 << m) <= n) {
            m++;
        }
        sparseTable = new int[n][m];
        for(int i = 0; i < n; i++) {
            sparseTable[i][0] = arr[i];
        }
        for(int j = 1; j < m; j++) {
            for(int i = 0; i < n-(1 << (j-1)); i++) {
                sparseTable[i][j] = Math.max(sparseTable[i][j-1], sparseTable[i+(1 << (j-1))][j-1]);
            }
        }
    }
    private static int query(int l, int r) {
        return Math.max(sparseTable[l][log[r-l+1]], sparseTable[r-(1 << log[r-l+1])+1][log[r-l+1]]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(n == -1 && k == -1) {
                break;
            }
            st = new StringTokenizer(f.readLine());
            arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            build();
            int low = 1;
            int high = n;
            int ans = -1;
            while(low <= high) {
                int mid = (low+high)/2;
                int seg = n/mid;
                int sum = 0;
                for(int i = 0; i < n/seg*seg; i += seg) {
                    sum += query(i, i+seg-1);
                }
                if(sum > k) {
                    high = mid-1;
                    ans = mid;
                } else {
                    low = mid+1;
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}