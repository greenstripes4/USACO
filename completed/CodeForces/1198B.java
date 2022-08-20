import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int q = Integer.parseInt(f.readLine());
        int[] max = new int[q];
        int[] pos = new int[n];
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(f.readLine());
            if(Integer.parseInt(st.nextToken()) == 1) {
                int p = Integer.parseInt(st.nextToken())-1;
                int x = Integer.parseInt(st.nextToken());
                a[p] = x;
                pos[p] = i;
            } else {
                int x = Integer.parseInt(st.nextToken());
                max[i] = x;
            }
        }
        for(int i = q-2; i >= 0; i--) {
            max[i] = Math.max(max[i], max[i+1]);
        }
        for(int i = 0; i < n; i++) {
            out.print(Math.max(max[pos[i]], a[i]) + " ");
        }
        out.println();
        f.close();
        out.close();
    }
}