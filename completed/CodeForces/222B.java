import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] p = new int[n][m];
        int[] r = new int[n];
        int[] c = new int[m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < m; j++) {
                p[i][j] = Integer.parseInt(st.nextToken());
                c[j] = j;
            }
            r[i] = i;
        }
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(f.readLine());
            char op = st.nextToken().charAt(0);
            if(op == 'c') {
                int c1 = Integer.parseInt(st.nextToken())-1;
                int c2 = Integer.parseInt(st.nextToken())-1;
                int temp = c[c1];
                c[c1] = c[c2];
                c[c2] = temp;
            } else if(op == 'r') {
                int r1 = Integer.parseInt(st.nextToken())-1;
                int r2 = Integer.parseInt(st.nextToken())-1;
                int temp = r[r1];
                r[r1] = r[r2];
                r[r2] = temp;
            } else {
                int r1 = Integer.parseInt(st.nextToken())-1;
                int c1 = Integer.parseInt(st.nextToken())-1;
                out.println(p[r[r1]][c[c1]]);
            }
        }
        f.close();
        out.close();
    }
}
