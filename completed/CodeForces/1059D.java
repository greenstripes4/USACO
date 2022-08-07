import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[][] points = new int[n][2];
        boolean neg = false;
        boolean pos = false;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
            if(points[i][1] > 0) {
                pos = true;
            } else {
                neg = true;
                points[i][1] = -points[i][1];
            }
        }
        if(pos && neg) {
            out.println(-1);
        } else {
            double low = 0;
            double high = 1e16;
            double ans = high;
            for(int j = 0; j < 200; j++) {
                double mid = (low+high)/2;
                double[] interval = {Double.MIN_VALUE, Double.MAX_VALUE};
                boolean flag = false;
                for(int[] i: points) {
                    double c = mid-i[1];
                    if(mid*mid < c*c) {
                        flag = true;
                        break;
                    }
                    double temp = Math.sqrt(mid*mid-c*c);
                    double l = i[0]-temp;
                    double r = i[0]+temp;
                    if(l > interval[1] || r < interval[0]) {
                        flag = true;
                        break;
                    }
                    interval[0] = Math.max(interval[0], l);
                    interval[1] = Math.min(interval[1], r);
                }
                if(flag) {
                    low = mid;
                } else {
                    high = mid;
                    ans = mid;
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}