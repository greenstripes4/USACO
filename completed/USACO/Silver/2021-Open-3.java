import java.io.*;
import java.util.*;

public class Main {
    private static int[] c;
    private static int K;
    private static int L;
    private static boolean isValid(int h) {
        long sum = 0;
        int max = 0;
        for(int i = 0; i < h; i++) {
            if(c[i] < h) {
                sum += h-c[i];
                max = Math.max(max, h-c[i]);
            }
        }
        return max <= K && sum <= ((long) K)*L;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        c = new int[N];
        for(int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(c);
        for(int i = 0; i < N/2; i++) {
            int temp = c[i];
            c[i] = c[N-i-1];
            c[N-i-1] = temp;
        }
        int low = 0;
        int high = N;
        int ans = 0;
        while(low <= high) {
            int mid = (low+high)/2;
            if(isValid(mid)) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
