import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] arr;
    private static int[][] sparseTable;
    private static int[] log;
    private static void build() {
        log = new int[N+1];
        for(int i = 2; i <= N; i++) {
            log[i] = log[i/2]+1;
        }
        int M = 0;
        while((1 << M) <= N) {
            M++;
        }
        sparseTable = new int[N][M];
        for(int i = 0; i < N; i++) {
            sparseTable[i][0] = arr[i];
        }
        for(int j = 1; j < M; j++) {
            for(int i = 0; i < N-(1 << (j-1)); i++) {
                sparseTable[i][j] = Math.max(sparseTable[i][j-1], sparseTable[i+(1 << (j-1))][j-1]);
            }
        }
    }
    private static int query(int l, int r) {
        return Math.max(sparseTable[l][log[r-l+1]], sparseTable[r-(1 << log[r-l+1])+1][log[r-l+1]]);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        f.close();
        out.close();
    }
}
