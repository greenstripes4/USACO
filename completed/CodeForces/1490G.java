import java.io.*;
import java.util.*;

public class Main {
    private static int ceil(long[] arr, int tar) {
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] >= tar) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            long[] pref = new long[n];
            long sum = 0;
            long max = Long.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                sum += a[i];
                max = Math.max(max, sum);
                pref[i] = i == 0 ? sum : Math.max(pref[i-1], sum);
            }
            st = new StringTokenizer(f.readLine());
            long[] res = new long[m];
            for(int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());
                if(sum <= 0 && x > max) {
                    res[i] = -1;
                } else if(sum <= 0) {
                    res[i] = ceil(pref, x);
                } else {
                    int low = 0;
                    int high = (int) ((x+sum-1)/sum);
                    long ans = high;
                    while(low <= high) {
                        int mid = (low+high)/2;
                        if(sum*mid+max >= x) {
                            high = mid-1;
                            ans = mid;
                        } else {
                            low = mid+1;
                        }
                    }
                    x -= sum*ans;
                    ans = ans*n-1;
                    if(x > 0) {
                        ans += ceil(pref, x)+1;
                    }
                    res[i] = ans;
                }
            }
            out.print(res[0]);
            for(int i = 1; i < m; i++) {
                out.print(" " + res[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
