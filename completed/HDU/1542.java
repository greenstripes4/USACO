import java.io.*;
import java.util.*;

public class Main {
    private static class Line implements Comparable<Line> {
        private double x1;
        private double x2;
        private double y;
        private int start;
        private Line(double x1, double x2, double y, int start) {
            this.x1 = x1;
            this.x2 = x2;
            this.y = y;
            this.start = start;
        }
        @Override
        public int compareTo(Line o) {
            return Double.compare(y, o.y);
        }
    }
    private static class Node {
        private int used;
        private double sum;
        private Node() {}
    }
    private static Double[] hash;
    private static Node[] segmentTree;
    private static int binarySearch(double v) {
        int low = 0;
        int high = hash.length-1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(Math.abs(hash[mid]-v) < 1e-6) {
                return mid;
            }
            if(hash[mid] < v) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
    private static void updateSum(int u, int l, int r) {
        if(l > r) {
            return;
        }
        if(segmentTree[u].used > 0) {
            segmentTree[u].sum = hash[r+1]-hash[l];
            return;
        }
        if(l == r) {
            segmentTree[u].sum = 0;
            return;
        }
        int m = (l+r)/2;
        updateSum(u*2, l, m);
        updateSum(u*2+1, m+1, r);
        segmentTree[u].sum = segmentTree[u*2].sum+segmentTree[u*2+1].sum;
    }
    private static void update(int u, int l, int r, int ll, int rr, int v) {
        if(l > r || l > rr || r < ll) {
            return;
        }
        if(l >= ll && r <= rr) {
            segmentTree[u].used += v;
            updateSum(u, l, r);
            return;
        }
        int m = (l+r)/2;
        update(u*2, l, m, ll, rr, v);
        update(u*2+1, m+1, r, ll, rr, v);
        updateSum(u, l, r);
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = 1;
        while(true) {
            int n = f.nextInt();
            if(n == 0) {
                break;
            }
            Line[] events = new Line[2*n];
            TreeSet<Double> compressed = new TreeSet<>();
            for(int i = 0; i < n; i++) {
                double x1 = f.nextDouble();
                double y1 = f.nextDouble();
                double x2 = f.nextDouble();
                double y2 = f.nextDouble();
                events[2*i] = new Line(x1, x2, y1, 1);
                events[2*i+1] = new Line(x1, x2, y2, -1);
                compressed.add(x1);
                compressed.add(x2);
            }
            Arrays.sort(events);
            hash = new Double[compressed.size()];
            hash = compressed.toArray(hash);
            int size = 1;
            while(size < hash.length-1) {
                size *= 2;
            }
            segmentTree = new Node[2*size];
            for(int i = 1; i < 2*size; i++) {
                segmentTree[i] = new Node();
            }
            double ans = 0;
            for(int i = 0; i < 2*n-1; i++) {
                int ll = binarySearch(events[i].x1);
                int rr = binarySearch(events[i].x2);
                update(1, 0, hash.length-2, ll, rr-1, events[i].start);
                ans += segmentTree[1].sum*(events[i+1].y-events[i].y);
            }
            out.println("Test case #" + t);
            out.println("Total explored area: " + String.format("%.2f", ans));
            out.println();
            t++;
        }
        f.close();
        out.close();
    }
}