import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] x = new int[N];
        for(int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(f.readLine());
        }
        Arrays.sort(x);
        int low = 1;
        int high = 1000000000;
        int ans = 1;
        while(low <= high) {
            int mid = (low+high)/2;
            int placed = 0;
            int idx = 0;
            while(placed < C && idx < N) {
                int cur = x[idx];
                while(idx < N && x[idx]-cur < mid) {
                    idx++;
                }
                placed++;
            }
            if(placed < C) {
                high = mid-1;
            } else {
                low = mid+1;
                ans = mid;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}