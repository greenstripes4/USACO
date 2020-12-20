import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("socdist.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[][] intervals = new long[M][2];
        long maxB = 0;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            intervals[i][0] = Long.parseLong(st.nextToken());
            intervals[i][1] = Long.parseLong(st.nextToken());
            maxB = Math.max(maxB, intervals[i][1]);
        }
        Arrays.sort(intervals, new Comparator<long[]>() {
            @Override
            public int compare(long[] longs, long[] t1) {
                return longs[0] < t1[0] ? -1 : 1;
            }
        });
        long lowD = 1;
        long highD = maxB;
        long ansD = 1;
        while(lowD <= highD) {
            long midD = (lowD+highD)/2;
            int placed = 0;
            int intervalIndex = 0;
            long position = intervals[0][0];
            while(placed < N) {
                placed++;
                position += midD;
                while(intervalIndex < M && intervals[intervalIndex][1] < position) {
                    intervalIndex++;
                }
                if(intervalIndex == M) {
                    break;
                }
                if(intervals[intervalIndex][0] > position) {
                    position = intervals[intervalIndex][0];
                }
            }
            if(placed == N) {
                lowD = midD+1;
                ansD = midD;
            } else {
                highD = midD-1;
            }
        }
        out.println(ansD);
        f.close();
        out.close();
    }
}
