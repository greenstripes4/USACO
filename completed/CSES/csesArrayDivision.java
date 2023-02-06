import java.io.*;
import java.util.*;

public class Main {
    private static boolean isValid(int[] x, int k, long tar) {
        long sum = 0;
        for(int i: x) {
            if(i > tar) {
                return false;
            }
            if(sum+i <= tar) {
                sum += i;
            } else {
                sum = i;
                k--;
            }
        }
        return k > 0;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] x = new int[n];
        long high = 0;
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            high += x[i];
        }
        long low = 0;
        long ans = -1;
        while(low <= high) {
            long mid = (low+high)/2;
            if(isValid(x, k, mid)) {
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