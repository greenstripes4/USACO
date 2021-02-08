import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int k = 0;
        while(1 << k <= n) {
            k++;
        }
        int[][] sparseTable = new int[n][k];
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            sparseTable[i][0] = Integer.parseInt(st.nextToken());
        }
        for(int j = 1; j < k; j++) {
            for(int i = 0; i < n; i++) {
                if(i+(1 << j) > n) {
                    break;
                }
                sparseTable[i][j] = Math.min(sparseTable[i][j-1], sparseTable[i+(1 << (j-1))][j-1]);
            }
        }
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int size = 0;
            while(1 << size <= b-a+1) {
                size++;
            }
            size--;
            out.println(Math.min(sparseTable[a][size], sparseTable[b-(1 << size)+1][size]));
        }
        f.close();
        out.close();
    }
}