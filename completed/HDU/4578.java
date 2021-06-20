import java.io.*;
import java.util.*;

public class Main{
    private static long[][] segmentTree;
    private static long[][] lazy;
    private static void push(int u, int l, int r, int t) {
        if(l > r) {
            return;
        }
        int m = (l+r)/2;
        update2(u*2, l, m, t, lazy[u][t]);
        update2(u*2+1, m+1, r, t, lazy[u][t]);
        lazy[u*2][t] = lazy[u][t];
        lazy[u*2+1][t] = lazy[u][t];
        lazy[u][t] = t == 1 ? 1 : 0;
    }
    private static void update2(int u, int l, int r, int t, long c) {
        if(l > r) {
            return;
        }
        if(t != 0 && lazy[u][0] > 0) {
            push(u, l, r, 0);
        }
        if(t != 1 && lazy[u][1] > 1) {
            push(u, l, r, 1);
        }
        if(t != 2 && lazy[u][2] > 0) {
            push(u, l, r, 2);
        }
        if(t == 0) {
            segmentTree[u][2] += (r-l+1)*c*c*c+3*c*(segmentTree[u][1]+c*segmentTree[u][0]);
            segmentTree[u][1] += (r-l+1)*c*c+2*c*segmentTree[u][0];
            segmentTree[u][0] += (r-l+1)*c;
            lazy[u][0] += c;
        } else if(t == 1) {
            segmentTree[u][2] *= c*c*c;
            segmentTree[u][1] *= c*c;
            segmentTree[u][0] *= c;
            lazy[u][1] *= c;
        } else {
            segmentTree[u][2] = (r-l+1)*c*c*c;
            segmentTree[u][1] = (r-l+1)*c*c;
            segmentTree[u][0] = (r-l+1)*c;
            lazy[u][2] = c;
        }
        for(int i = 0; i < 3; i++) {
            segmentTree[u][i] %= 10007;
            lazy[u][i] %= 10007;
        }
    }
    private static void update(int u, int l, int r, int ll, int rr, int t, long c) {
        if(l > r || l > rr || r < ll) {
            return;
        }
        if(l >= ll && r <= rr) {
            update2(u, l, r, t, c);
            return;
        }
        push(u, l, r, 0);
        push(u, l, r, 1);
        push(u, l, r, 2);
        int m = (l+r)/2;
        update(u*2, l, m, ll, rr, t, c);
        update(u*2+1, m+1, r, ll, rr, t, c);
        for(int i = 0; i < 3; i++) {
            segmentTree[u][i] = (segmentTree[u*2][i]+segmentTree[u*2+1][i])%10007;
        }
    }
    private static long query(int u, int l, int r, int ll, int rr, int t) {
        if(l > r || l > rr || r < ll) {
            return 0;
        }
        if(l >= ll && r <= rr) {
            return segmentTree[u][t];
        }
        push(u, l, r, 0);
        push(u, l, r, 1);
        push(u, l, r, 2);
        int m = (l+r)/2;
        return (query(u*2, l, m, ll, rr, t)+query(u*2+1, m+1, r, ll, rr, t))%10007;
    }
    public static void main(String[] args) throws IOException{
        Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int n = f.nextInt();
            int m = f.nextInt();
            if(n == 0 || m == 0) {
                break;
            }
            int size = 1;
            while(size < n) {
                size *= 2;
            }
            segmentTree = new long[2*size][3];
            lazy = new long[2*size][3];
            for(int i = 1; i < 2*size; i++) {
                lazy[i][1] = 1;
            }
            for(int i = 0; i < m; i++) {
                int t = f.nextInt()-1;
                int x = f.nextInt()-1;
                int y = f.nextInt()-1;
                if(t == 3) {
                    int p = f.nextInt()-1;
                    out.println(query(1, 0, n-1, x, y, p));
                } else {
                    int c = f.nextInt();
                    update(1, 0, n-1, x, y, t, c);
                }
            }
        }
        f.close();
        out.close();
    }
}