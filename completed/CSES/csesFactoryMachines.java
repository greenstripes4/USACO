import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] k = new int[n];
        st = new StringTokenizer(f.readLine());
        long min = 1000000000;
        for(int i = 0; i < n; i++) {
            k[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, k[i]);
        }
        long low = 1;
        long high = t*min;
        long ans = -1;
        while(low <= high) {
            long mid = (low+high)/2;
            long sum = 0;
            for(int i = 0; i < n; i++) {
                sum += mid/k[i];
            }
            if(sum < t) {
                low = mid+1;
            } else {
                high = mid-1;
                ans = mid;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}