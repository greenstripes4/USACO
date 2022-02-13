import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(n*a != m*b) {
                out.println("NO");
            } else {
                out.println("YES");
                char[][] res = new char[n][m];
                int idx = 0;
                for(int i = 0; i < n; i++) {
                    Arrays.fill(res[i], '0');
                    for(int j = 0; j < a; j++) {
                        res[i][idx++] = '1';
                        idx %= m;
                    }
                }
                for(char[] i: res) {
                    out.println(i);
                }
            }
        }
        f.close();
        out.close();
    }
}
