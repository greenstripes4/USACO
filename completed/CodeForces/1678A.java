import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("paintbarn.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] occ = new int[101];
            for(int i = 0; i < n; i++) {
                occ[Integer.parseInt(st.nextToken())]++;
            }
            int max = 0;
            for(int i: occ) {
                max = Math.max(max, i);
            }
            if(occ[0] > 0) {
                out.println(n-occ[0]);
            } else if(max > 1) {
                out.println(n);
            } else {
                out.println(n+1);
            }
        }
        f.close();
        out.close();
    }
}