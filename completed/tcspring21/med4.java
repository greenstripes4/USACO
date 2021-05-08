import java.io.*;
import java.util.*;

public class program {
    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int[] i: intervals) {
            if(i[0] <= end) {
                end = Math.max(end, i[1]);
            } else {
                list.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        list.add(new int[]{start, end});
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        int N = f.nextInt();
        int M = f.nextInt();
        int R = f.nextInt();
        int[][] intervals = new int[N][2];
        for(int i = 0; i < N; i++) {
            int pos = f.nextInt();
            intervals[i][0] = pos-R;
            intervals[i][1] = pos+R;
        }
        intervals = merge(intervals);
        int ans = intervals.length+1;
        if(intervals[0][0] <= 0) {
            ans--;
        }
        if(intervals[intervals.length-1][1] >= M) {
            ans--;
        }
        System.out.println(ans);
        f.close();
    }
}
