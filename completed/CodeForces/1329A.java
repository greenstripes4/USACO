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
        st = new StringTokenizer(f.readLine());
        int[] l = new int[m];
        long length = 0;
        int max = 0;
        for(int i = 0; i < m; i++) {
            l[i] = Integer.parseInt(st.nextToken());
            length += l[i];
            max = Math.max(max, i+l[i]);
        }
        if(length < n || max > n) {
            out.println(-1);
        } else {
            int[] p = new int[m];
            for(int i = 0; i < m; i++) {
                p[i] = i;
            }
            int i = m-1;
            int end = n;
            while(p[i]+l[i] < end) {
                p[i] = end-l[i];
                end = p[i];
                i--;
            }
            out.print(p[0]+1);
            for(int j = 1; j < m; j++) {
                out.print(" " + (p[j]+1));
            }
            out.println();
        }
        f.close();
        out.close();
    }
}