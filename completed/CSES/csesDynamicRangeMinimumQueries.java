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
        int[] segmentTree = new int[2*n];
        for(int i = n; i < 2*n; i++) {
            segmentTree[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = n-1; i > 0; i--) {
            segmentTree[i] = Math.min(segmentTree[i << 1], segmentTree[i << 1 | 1]);
        }
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(f.readLine());
            int type = Integer.parseInt(st.nextToken());
            if(type == 1) {
                int k = Integer.parseInt(st.nextToken())+n-1;
                int u = Integer.parseInt(st.nextToken());
                segmentTree[k] = u;
                while(k > 1) {
                    segmentTree[k >> 1] = Math.min(segmentTree[k], segmentTree[k^1]);
                    k >>= 1;
                }
            } else {
                int a = Integer.parseInt(st.nextToken())+n-1;
                int b = Integer.parseInt(st.nextToken())+n-1;
                int min = Integer.MAX_VALUE;
                while(a <= b) {
                    if(a%2 == 1) {
                        min = Math.min(min, segmentTree[a++]);
                    }
                    if(b%2 == 0) {
                        min = Math.min(min, segmentTree[b--]);
                    }
                    a >>= 1;
                    b >>= 1;
                }
                out.println(min);
            }
        }
        f.close();
        out.close();
    }
}