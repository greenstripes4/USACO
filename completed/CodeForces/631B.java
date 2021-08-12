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
        int[] ar = new int[n];
        int[] tr = new int[n];
        int[] ac = new int[m];
        int[] tc = new int[m];
        for(int i = 1; i <= k; i++) {
            st = new StringTokenizer(f.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken())-1;
            int a = Integer.parseInt(st.nextToken());
            if(t == 1) {
                ar[x] = a;
                tr[x] = i;
            } else {
                ac[x] = a;
                tc[x] = i;
            }
        }
        for(int i = 0; i < n; i++) {
            if(tr[i] > tc[0]) {
                out.print(ar[i]);
            } else {
                out.print(ac[0]);
            }
            for(int j = 1; j < m; j++) {
                if(tr[i] > tc[j]) {
                    out.print(" " + ar[i]);
                } else {
                    out.print(" " + ac[j]);
                }
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
