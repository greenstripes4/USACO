import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("mountains.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
        int N = Integer.parseInt(f.readLine());
        int[][] intervals = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            intervals[i][0] = x-y;
            intervals[i][1] = x+y;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if(ints[1] == t1[1]) {
                    return ints[0]-t1[0];
                }
                return t1[1]-ints[1];
            }
        });
        int lastStart = Integer.MAX_VALUE;
        int cnt = 0;
        for(int[] i: intervals) {
            if(i[0] < lastStart) {
                cnt++;
                lastStart = i[0];
            }
        }
        out.println(cnt);
        f.close();
        out.close();
    }
}
