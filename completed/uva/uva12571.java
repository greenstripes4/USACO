import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] x = new int[N];
            for(int i = 0; i < N; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }
            int[] q = new int[230];
            for(int i = 0; i < 230; i++) {
                for(int j: x) {
                    q[i] = Math.max(q[i], i&j);
                }
            }
            for(int i = 0; i < Q; i++) {
                int a = Integer.parseInt(f.readLine());
                out.println(q[a]);
            }
        }
        f.close();
        out.close();
    }
}