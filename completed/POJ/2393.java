import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] C = new int[N];
        int[] Y = new int[N];
        long ans = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            C[i] = Integer.parseInt(st.nextToken());
            if(i > 0 && C[i-1]+S < C[i]) {
                C[i] = C[i-1]+S;
            }
            Y[i] = Integer.parseInt(st.nextToken());
            ans += C[i]*Y[i];
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
