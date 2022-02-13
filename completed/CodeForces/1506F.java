import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[][] points = new int[n+1][2];
            for(int i = 0; i < n; i++) {
                points[i][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(f.readLine());
            for(int i = 0; i < n; i++) {
                points[i][1] = Integer.parseInt(st.nextToken());
            }
            points[n][0] = 1;
            points[n][1] = 1;
            Arrays.sort(points, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[0]-t1[0];
                }
            });
            long ans = 0;
            for(int i = 1; i <= n; i++) {
                long r1 = points[i-1][0];
                long c1 = points[i-1][1];
                long r2 = points[i][0];
                long c2 = points[i][1];
                long left = r2-r1-c2+c1;
                long right = c2-c1;
                if((r1+c1)%2 == 0) {
                    ans += left/2;
                    if(left == 0) {
                        ans += right;
                    }
                } else {
                    ans += (left+1)/2;
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}
