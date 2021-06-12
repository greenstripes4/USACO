import java.io.*;
import java.util.*;

public class Main {
    private static int[][] segmentTree;
    private static char[] arr;
    private static int[] occ;
    private static void build(int u, int l, int r) {
        if(l > r) {
            return;
        }
        if(l == r) {
            segmentTree[u][arr[l]-'a'] = 1;
            return;
        }
        int m = (l+r)/2;
        build(u*2, l, m);
        build(u*2+1, m+1, r);
        for(int i = 0; i < 26; i++) {
            segmentTree[u][i] = segmentTree[u*2][i]+segmentTree[u*2+1][i];
        }
    }
    private static void update(int u, int l, int r, int p, char v) {
        if(l > p || r < p) {
            return;
        }
        if(l == r) {
            segmentTree[u][arr[l]-'a'] = 0;
            segmentTree[u][v-'a'] = 1;
            arr[l] = v;
            return;
        }
        int m = (l+r)/2;
        update(u*2, l, m, p, v);
        update(u*2+1, m+1, r, p, v);
        for(int i = 0; i < 26; i++) {
            segmentTree[u][i] = segmentTree[u*2][i]+segmentTree[u*2+1][i];
        }
    }
    private static void query(int u, int l, int r, int ll, int rr) {
        if(l > r || l > rr || r < ll) {
            return;
        }
        if(l >= ll && r <= rr) {
            for(int i = 0; i < 26; i++) {
                occ[i] += segmentTree[u][i];
            }
            return;
        }
        int m = (l+r)/2;
        query(u*2, l, m, ll, rr);
        query(u*2+1, m+1, r, ll, rr);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("beads.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        arr = f.readLine().toCharArray();
        int size = 1;
        while(size < arr.length) {
            size *= 2;
        }
        segmentTree = new int[2*size][26];
        build(1, 0, arr.length-1);
        int q = Integer.parseInt(f.readLine());
        while(q-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            if(Integer.parseInt(st.nextToken()) == 1) {
                int pos = Integer.parseInt(st.nextToken())-1;
                char c = st.nextToken().charAt(0);
                update(1, 0, arr.length-1, pos, c);
            } else {
                int l = Integer.parseInt(st.nextToken())-1;
                int r = Integer.parseInt(st.nextToken())-1;
                occ = new int[26];
                query(1, 0, arr.length-1, l, r);
                int ans = 0;
                for(int i: occ) {
                    if(i > 0) {
                        ans++;
                    }
                }
                out.println(ans);
            }
        }
        f.close();
        out.close();
    }
}
