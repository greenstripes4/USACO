import java.io.*;
import java.util.*;

public class Main {
    private static int[] segmentTree;
    private static void update(int idx, int left, int right, int rangeLeft, int rangeRight, int val) {
        if(left > right) {
            return;
        }
        if(left > rangeRight || right < rangeLeft) {
            return;
        }
        if(left >= rangeLeft && right <= rangeRight) {
            segmentTree[idx] = val;
            return;
        }
        if(segmentTree[idx] > 0) {
            segmentTree[idx*2] = segmentTree[idx];
            segmentTree[idx*2+1] = segmentTree[idx];
            segmentTree[idx] = 0;
        }
        int mid = (left+right)/2;
        update(idx*2, left, mid, rangeLeft, rangeRight, val);
        update(idx*2+1, mid+1, right, rangeLeft, rangeRight, val);
    }
    private static void query(int idx, int left, int right) {
        if(left >= right) {
            return;
        }
        if(segmentTree[idx] > 0) {
            segmentTree[idx*2] = segmentTree[idx];
            segmentTree[idx*2+1] = segmentTree[idx];
            segmentTree[idx] = 0;
        }
        int mid = (left+right)/2;
        query(idx*2, left, mid);
        query(idx*2+1, mid+1, right);
    }
    private static int compress(int[][] arr) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int[] i: arr) {
            set.add(i[0]-1);
            set.add(i[0]);
            set.add(i[0]+1);
            set.add(i[1]-1);
            set.add(i[1]);
            set.add(i[1]+1);
        }
        while(set.first() < 0) {
            set.remove(set.first());
        }
        ArrayList<Integer> temp = new ArrayList<Integer>(set);
        for(int[] i: arr) {
            i[0] = Collections.binarySearch(temp, i[0]);
            i[1] = Collections.binarySearch(temp, i[1]);
        }
        return temp.size();
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int c = Integer.parseInt(f.readLine());
        while(c-- > 0) {
            int n = Integer.parseInt(f.readLine());
            int[][] intervals = new int[n][2];
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                intervals[i][0] = Integer.parseInt(st.nextToken())-1;
                intervals[i][1] = Integer.parseInt(st.nextToken())-1;
            }
            int l = compress(intervals);
            int size = 1;
            while(size < l) {
                size *= 2;
            }
            segmentTree = new int[2*size];
            for(int i = 0; i < n; i++) {
                update(1, 0, l-1, intervals[i][0], intervals[i][1], i+1);
            }
            query(1, 0, l-1);
            boolean[] seen = new boolean[n+1];
            int count = 0;
            for(int i: segmentTree) {
                if(i > 0 && !seen[i]) {
                    seen[i] = true;
                    count++;
                }
            }
            out.println(count);
        }
        f.close();
        out.close();
    }
}