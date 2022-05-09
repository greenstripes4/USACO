import java.io.*;
import java.util.*;

public class Main {
    private static long M;
    private static int[][] arr;
    private static boolean isValid(int k) {
        long sum = 0;
        for(int[] i: arr) {
            if(i[1] > k) {
                sum = 0;
                continue;
            }
            sum += i[0];
            if(sum >= M) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("hayfeast.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hayfeast.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int low = 1;
        int high = 1000000000;
        int ans = high;
        while(low <= high) {
            int mid = (low+high)/2;
            if(isValid(mid)) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}