import java.io.*;
import java.util.*;

public class Main {
    private static int[] segmentTree;
    private static int[] arr;
    private static void build(int u) {
        if(u*2 >= arr.length) {
            segmentTree[u] = arr[u] == 2 ? 2 : 1;
            return;
        }
        build(u*2);
        build(u*2+1);
        segmentTree[u] = arr[u] == 2 ? segmentTree[u*2]+segmentTree[u*2+1] : arr[u] == 1 ? segmentTree[u*2] : segmentTree[u*2+1];
    }
    private static void update(int u) {
        if(u == 0) {
            return;
        }
        if(u*2 >= arr.length) {
            segmentTree[u] = arr[u] == 2 ? 2 : 1;
        } else {
            segmentTree[u] = arr[u] == 2 ? segmentTree[u*2]+segmentTree[u*2+1] : arr[u] == 1 ? segmentTree[u*2] : segmentTree[u*2+1];
        }
        update(u/2);
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int k = Integer.parseInt(f.readLine());
        char[] s = f.readLine().toCharArray();
        for(int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = temp;
        }
        arr = new int[1 << k];
        for(int i = 1; i < 1 << k; i++) {
            arr[i] = s[i-1] == '?' ? 2 : s[i-1]-'0';
        }
        segmentTree = new int[1 << k];
        build(1);
        int q = Integer.parseInt(f.readLine());
        for(int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int p = (1 << k)-Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            arr[p] = c == '?' ? 2 : c-'0';
            update(p);
            out.println(segmentTree[1]);
        }
        f.close();
        out.close();
    }
}