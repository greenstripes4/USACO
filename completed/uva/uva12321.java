import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int L = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int[][] intervals = new int[G][2];
            for(int i = 0; i < G; i++) {
                st = new StringTokenizer(f.readLine());
                int x = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                intervals[i][0] = x-r;
                intervals[i][1] = x+r;
            }
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    if(ints[0] == t1[0]) {
                        return t1[1]-ints[1];
                    }
                    return ints[0]-t1[0];
                }
            });
            int needed = 0;
            int end = 0;
            int i = 0;
            while(end < L) {
                int nextEnd = end;
                while(i < G && intervals[i][0] <= end) {
                    nextEnd = Math.max(nextEnd,intervals[i][1]);
                    i++;
                }
                if(nextEnd == end) {
                    break;
                }
                end = nextEnd;
                needed++;
            }
            out.println(end < L ? -1 : G-needed);
        }
        f.close();
        out.close();
    }
}
