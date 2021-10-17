import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException{
                //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
                BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
                StringTokenizer st = new StringTokenizer(f.readLine());
                int n = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());
                st = new StringTokenizer(f.readLine());
                long[] v = new long[n];
                for(int i = 0; i < n; i++) {
                        v[i] = Integer.parseInt(st.nextToken());
                }
                st = new StringTokenizer(f.readLine());
                int[] c = new int[n];
                for(int i = 0; i < n; i++) {
                        c[i] = Integer.parseInt(st.nextToken())-1;
                }
                while(q-- > 0) {
                        st = new StringTokenizer(f.readLine());
                        long a = Integer.parseInt(st.nextToken());
                        long b = Integer.parseInt(st.nextToken());
                        long[] max = new long[n];
                        Arrays.fill(max, Long.MIN_VALUE);
                        int mIdx = 0;
                        int smIdx = 1;
                        for(int i = 0; i < n; i++) {
                                if(max[c[i]] > Long.MIN_VALUE) {
                                        max[c[i]] = Math.max(max[c[i]], max[c[i]]+v[i]*a);
                                }
                                long om = Math.max(0, mIdx == c[i] ? max[smIdx] : max[mIdx]);
                                max[c[i]] = Math.max(max[c[i]], om+v[i]*b);
                                if(max[c[i]] > max[mIdx]) {
                                        smIdx = mIdx;
                                        mIdx = c[i];
                                } else if(c[i] != mIdx && max[c[i]] > max[smIdx]) {
                                        smIdx = c[i];
                                }
                        }
                        out.println(Math.max(0, max[mIdx]));
                }
                f.close();
                out.close();
    }
}
