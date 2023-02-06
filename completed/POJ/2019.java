import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[][] arr;
    private static int[][][][] sparseTable;
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
        sparseTable = new int[n][n][m][2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sparseTable[i][j][0][0] = sparseTable[i][j][0][1] = arr[i][j];
            }
        }
        for(int k = 0; k < n; k++) {
            for(int j = 1; j < m; j++) {
                for(int i = 0; i < n-(1 << (j-1)); i++) {
                    sparseTable[k][i][j][0] = Math.min(sparseTable[k][i][j-1][0], sparseTable[k][i+(1 << (j-1))][j-1][0]);
                    sparseTable[k][i][j][1] = Math.max(sparseTable[k][i][j-1][1], sparseTable[k][i+(1 << (j-1))][j-1][1]);
                }
            }
        }
    }
    private static int query(int top, int left, int B) {
        int min = 250;
        int max = 0;
        for(int i = 0; i < B; i++) {
            min = Math.min(min, Math.min(sparseTable[top+i][left][log[B]][0], sparseTable[top+i][left+B-(1 << log[B])][log[B]][0]));
            max = Math.max(max, Math.max(sparseTable[top+i][left][log[B]][1], sparseTable[top+i][left+B-(1 << log[B])][log[B]][1]));
        }
        return max-min;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        build();
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(f.readLine());
            int top = Integer.parseInt(st.nextToken())-1;
            int left = Integer.parseInt(st.nextToken())-1;
            out.println(query(top, left, B));
        }
        f.close();
        out.close();
    }
}