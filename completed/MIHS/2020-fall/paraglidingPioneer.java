import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class paraglidingPioneer {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = f.nextInt();
        int[][] intervals = new int[N*2][2];
        for(int i = 0; i < N; i++) {
            int Li = f.nextInt();
            int Ui = f.nextInt();
            intervals[i*2][0] = Li;
            intervals[i*2][1] = 0;
            intervals[i*2+1][0] = Ui+1;
            intervals[i*2+1][1] = 1;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0]-t1[0];
            }
        });
        int bestPosition = -1;
        int maxIntersections = 0;
        int intersections = 0;
        for(int[] i: intervals) {
            if(i[1] == 0) {
                intersections++;
                if(intersections > maxIntersections) {
                    bestPosition = i[0];
                    maxIntersections = intersections;
                }
            } else {
                intersections--;
            }
        }
        out.println(bestPosition);
        f.close();
        out.close();
    }
}
