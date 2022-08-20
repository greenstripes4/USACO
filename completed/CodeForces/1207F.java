import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[] a = new int[500001];
        int[][] ans = new int[701][701];
        int q = Integer.parseInt(f.readLine());
        while(q-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(t == 1) {
                a[x] += y;
                for(int i = 1; i <= 700; i++) {
                    ans[i][x%i] += y;
                }
            } else {
                if(x <= 700) {
                    out.println(ans[x][y]);
                } else {
                    int val = 0;
                    for(int i = y; i <= 500000; i += x) {
                        val += a[i];
                    }
                    out.println(val);
                }
            }
        }
        f.close();
        out.close();
    }
}