import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(f.readLine());
            int[] b = new int[n];
            int ones = 0;
            int twos = 0;
            for(int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
                if(b[i] == 1) {
                    ones++;
                } else {
                    twos++;
                }
            }
            int high = ones+2*twos;
            int[] regular = new int[ones];
            int[] important = new int[twos];
            for(int i = 0; i < n; i++) {
                if(b[i] == 1) {
                    regular[--ones] = a[i];
                } else {
                    important[--twos] = a[i];
                }
            }
            Arrays.sort(regular);
            Arrays.sort(important);
            long[] prefixSum1 = new long[regular.length+1];
            for(int i = 1; i <= regular.length; i++) {
                prefixSum1[i] = prefixSum1[i-1]+regular[regular.length-i];
            }
            long[] prefixSum2 = new long[important.length+1];
            for(int i = 1; i <= important.length; i++) {
                prefixSum2[i] = prefixSum2[i-1]+important[important.length-i];
            }
            int low = 0;
            int ans = -1;
            while(low <= high) {
                int mid = (low+high)/2;
                boolean valid = false;
                for(int i = 0; i <= Math.min(regular.length, mid); i++) {
                    if(prefixSum1[i]+prefixSum2[Math.min(important.length, (mid-i)/2)] >= m) {
                        valid = true;
                        break;
                    }
                }
                if(valid) {
                    ans = mid;
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}