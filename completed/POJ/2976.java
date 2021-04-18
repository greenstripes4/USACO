import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int k = n-Integer.parseInt(st.nextToken());
            final int[] v = new int[n];
            final int[] w = new int[n];
            Integer[] dummy = new Integer[n];
            st = new StringTokenizer(f.readLine());
            for(int i = 0; i < n; i++) {
                v[i] = Integer.parseInt(st.nextToken());
                dummy[i] = i;
            }
            st = new StringTokenizer(f.readLine());
            for(int i = 0; i < n; i++) {
                w[i] = Integer.parseInt(st.nextToken());
            }
            double low = 0;
            double high = 1000000000000L;
            long ans = 0;
            double eps = Math.pow(10, -6);
            while(high-low > eps) {
                final double mid = (low+high)/2;
                Arrays.sort(dummy, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer integer, Integer t1) {
                        double temp = (v[integer]-mid*w[integer])-(v[t1]-mid*w[t1]);
                        return temp == 0 ? 0 : temp > 0 ? -1 : 1;
                    }
                });
                double max = 0;
                for(int i = 0; i < k; i++) {
                    max += v[dummy[i]]-mid*w[dummy[i]];
                }
                ans = (long) (100*mid);
                double diff = 100*mid-ans;
                if(diff >= 0.5) {
                    ans++;
                }
                if(max < 0) {
                    high = mid;
                } else {
                    low = mid;
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}