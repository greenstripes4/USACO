import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcase = 1;
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            double[][] intervals = new double[n][2];
            boolean valid = true;
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(f.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if(d < y) {
                    valid = false;
                    continue;
                }
                double spread = Math.sqrt(d*d-y*y);
                intervals[i][0] = x-spread;
                intervals[i][1] = x+spread;
            }
            if(!valid) {
                out.println("Case " + testcase + ": " + -1);
                testcase++;
                f.readLine();
                continue;
            }
            Arrays.sort(intervals, new Comparator<double[]>() {
                @Override
                public int compare(double[] doubles, double[] t1) {
                    if(doubles[1]-t1[1] < 0) {
                        return -1;
                    }
                    if(doubles[1]-t1[1] > 0) {
                        return 1;
                    }
                    return 0;
                }
            });
            int radars = 1;
            double lastEndpoint = intervals[0][1];
            for(double[] i: intervals) {
                if(lastEndpoint < i[0]) {
                    radars++;
                    lastEndpoint = i[1];
                }
            }
            out.println("Case " + testcase + ": " + radars);
            testcase++;
            f.readLine();
        }
        f.close();
        out.close();
    }
}