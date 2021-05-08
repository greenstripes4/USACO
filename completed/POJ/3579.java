import java.io.*;
import java.util.*;

public class Main {
    private static int binarySearch(int[] X, int low, int tar) {
        int high = X.length-1;
        int ans = low;
        while(low <= high) {
            int mid = (low+high)/2;
            if(X[mid] <= tar) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    private static boolean isValid(int[] X, int diff) {
        long count = 0;
        for(int i = 0; i < X.length-1; i++) {
            count += binarySearch(X, i, X[i]+diff)-i;
        }
        long temp = X.length;
        return count >= (temp*(temp-1)+3)/4;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(f.hasNext()) {
            int N = f.nextInt();
            int[] X = new int[N];
            int min = Integer.MAX_VALUE;
            int max = 0;
            for(int i = 0; i < N; i++) {
                X[i] = f.nextInt();
                min = Math.min(min, X[i]);
                max = Math.max(max, X[i]);
            }
            Arrays.sort(X);
            int low = 0;
            int high = max-min;
            int ans = -1;
            while(low <= high) {
                int mid = (low+high)/2;
                if(isValid(X, mid)) {
                    high = mid-1;
                    ans = mid;
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