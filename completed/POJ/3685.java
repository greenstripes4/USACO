import java.io.*;
import java.util.*;

public class Main {
    private static long solve(long i, long j) {
        return i*i+100000*i+j*j-100000*j+i*j;
    }
    private static int binarySearch(int N, long k, int j) {
        int low = 1;
        int high = N;
        int ans = 0;
        while(low <= high) {
            int mid = (low+high)/2;
            if(solve(mid, j) <= k) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    private static boolean isValid(int N, long M, long k) {
        long count = 0;
        for(int j = 1; j <= N; j++) {
            count += binarySearch(N, k, j);
        }
        return count >= M;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = f.nextInt();
        while(T-- > 0) {
            int N = f.nextInt();
            long M = f.nextLong();
            long low = -5000000000L;
            long high = 12500000000L;
            long ans = Long.MIN_VALUE;
            while(low <= high) {
                long mid = (low+high)/2;
                if(isValid(N, M, mid)) {
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