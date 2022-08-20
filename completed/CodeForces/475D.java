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
                sparseTable[i][j] = gcd(sparseTable[i][j-1], sparseTable[i+(1 << (j-1))][j-1]);
            }
        }
    }
    private static int query(int l, int r) {
        return gcd(sparseTable[l][log[r-l+1]], sparseTable[r-(1 << log[r-l+1])+1][log[r-l+1]]);
    }
    private static int gcd(int a, int b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        build();
        HashMap<Integer, Long> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int gcd = 0;
            int j = i;
            while(j < n) {
                gcd = gcd(gcd, arr[j]);
                int low = j;
                int high = n-1;
                int ans = j;
                while(low <= high) {
                    int mid = (low+high)/2;
                    if(query(j, mid) == gcd) {
                        low = mid+1;
                        ans = mid;
                    } else {
                        high = mid-1;
                    }
                }
                map.put(gcd, map.getOrDefault(gcd, 0L)+ans-j+1);
                j = ans+1;
            }
        }
        int q = Integer.parseInt(f.readLine());
        while(q-- > 0) {
            int x = Integer.parseInt(f.readLine());
            out.println(map.getOrDefault(x, 0L));
        }
        f.close();
        out.close();
    }
}