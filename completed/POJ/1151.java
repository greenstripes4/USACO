import java.io.*;
import java.util.*;

public class Main {
    private static int[] segmentTree;
    private static double[] sum;
    private static double[] pos;
    private static void update(int u, int l, int r, int ll, int rr, int v) {
        if(l > r || l > rr || r < ll) {
            return;
        }
        if(l >= ll && r <= rr && segmentTree[u] >= 0) {
            segmentTree[u] += v;
            sum[u] = (segmentTree[u] > 0 ? pos[r+1]-pos[l] : 0);
            return;
        }
        int m = (l+r)/2;
        if(segmentTree[u] >= 0) {
            segmentTree[u*2] = segmentTree[u*2+1] = segmentTree[u];
            sum[u*2] = (segmentTree[u] > 0 ? pos[m+1]-pos[l] : 0);
            sum[u*2+1] = (segmentTree[u] > 0 ? pos[r+1]-pos[m+1] : 0);
        }
        update(u*2, l, m, ll, rr, v);
        update(u*2+1, m+1, r, ll, rr, v);
        if(segmentTree[u*2] == -1 || segmentTree[u*2+1] == -1 || segmentTree[u*2] != segmentTree[u*2+1]) {
            segmentTree[u] = -1;
        } else {
            segmentTree[u] = segmentTree[u*2];
        }
        sum[u] = sum[u*2]+sum[u*2+1];
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = 1;
        while(true) {
            int n = Integer.parseInt(f.readLine());
            if(n == 0) {
                break;
            }
            TreeSet<Double> set = new TreeSet<>();
            double[][] arr = new double[n][4];
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                arr[i][0] = Double.parseDouble(st.nextToken());
                arr[i][1] = Double.parseDouble(st.nextToken());
                arr[i][2] = Double.parseDouble(st.nextToken());
                arr[i][3] = Double.parseDouble(st.nextToken());
                set.add(arr[i][0]);
                set.add(arr[i][1]);
                set.add(arr[i][2]);
                set.add(arr[i][3]);
            }
            HashMap<Double, Integer> map = new HashMap<>();
            pos = new double[set.size()];
            int idx = 0;
            for(double i: set) {
                pos[idx] = i;
                map.put(i, idx++);
            }
            int[][] events = new int[2*n][4];
            for(int i = 0; i < n; i++) {
                events[i*2][0] = map.get(arr[i][0]);
                events[i*2][1] = 1;
                events[i*2][2] = map.get(arr[i][1]);
                events[i*2][3] = map.get(arr[i][3])-1;
                events[i*2+1][0] = map.get(arr[i][2]);
                events[i*2+1][1] = -1;
                events[i*2+1][2] = map.get(arr[i][1]);
                events[i*2+1][3] = map.get(arr[i][3])-1;
            }
            Arrays.sort(events, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });
            int size = 1;
            while(size < set.size()-1) {
                size *= 2;
            }
            segmentTree = new int[2*size];
            sum = new double[2*size];
            double ans = 0;
            int prev = 0;
            for(int[] i: events) {
                ans += (pos[i[0]]-pos[prev])*sum[1];
                update(1, 0, set.size()-2, i[2], i[3], i[1]);
                prev = i[0];
            }
            out.println("Test case #" + t++);
            out.println("Total explored area: " + String.format("%.2f", ans));
            out.println();
        }
        f.close();
        out.close();
    }
}