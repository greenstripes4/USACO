import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
                //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
                //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));
                int N = Integer.parseInt(f.readLine());
                StringTokenizer st = new StringTokenizer(f.readLine());
                int[] V = new int[N];
                for(int i = 0; i < N; i++) {
                    V[i] = Integer.parseInt(st.nextToken());
                }
                st = new StringTokenizer(f.readLine());
                int[] C = new int[N];
                for(int i = 0; i < N; i++) {
                    C[i] = Integer.parseInt(st.nextToken());
                }
                int ans = 0;
                for(int i = 0; i < N; i++) {
                    if(V[i]-C[i] > 0) {
                        ans += V[i]-C[i];
                    }
                }
                out.println(ans);
                f.close();
                out.close();
        }
}
