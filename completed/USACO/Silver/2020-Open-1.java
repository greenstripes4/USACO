import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("socdist.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[][] arr = new long[M][2];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<long[]>() {
            @Override
            public int compare(long[] longs, long[] t1) {
                return Long.compare(longs[0], t1[0]);
            }
        });
        long low = 0;
        long high = Long.MAX_VALUE;
        long ans = 0;
        while(low <= high) {
            long mid = low+(high-low)/2;
            int idx = 0;
            long cur = arr[0][0];
            boolean flag = false;
            for(int i = 0; i < N; i++) {
                while(idx < M && arr[idx][1] < cur) {
                    idx++;
                }
                if(idx == M) {
                    flag = true;
                    break;
                }
                cur = Math.max(cur, arr[idx][0])+mid;
            }
            if(flag) {
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