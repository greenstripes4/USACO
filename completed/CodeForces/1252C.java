import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] R = new int[N+1];
        for(int i = 1; i <= N; i++) {
            R[i] = R[i-1]+Integer.parseInt(st.nextToken())%2;
        }
        st = new StringTokenizer(f.readLine());
        int[] C = new int[N+1];
        for(int i = 1; i <= N; i++) {
            C[i] = C[i-1]+Integer.parseInt(st.nextToken())%2;
        }
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(f.readLine());
            int ra = Integer.parseInt(st.nextToken());
            int ca = Integer.parseInt(st.nextToken());
            int rb = Integer.parseInt(st.nextToken());
            int cb = Integer.parseInt(st.nextToken());
            if(ra > rb) {
                int temp = ra;
                ra = rb;
                rb = temp;
            }
            if(ca > cb) {
                int temp = ca;
                ca = cb;
                cb = temp;
            }
            int r = R[rb]-R[ra-1];
            if(r > 0 && r <= rb-ra) {
                out.println("NO");
                continue;
            }
            boolean temp1 = r == 0;
            int c = C[cb]-C[ca-1];
            if(c > 0 && c <= cb-ca) {
                out.println("NO");
                continue;
            }
            boolean temp2 = c == 0;
            out.println(temp1 == temp2 ? "YES" : "NO");
        }
        f.close();
        out.close();
    }
}
