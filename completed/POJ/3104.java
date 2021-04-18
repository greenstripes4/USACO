import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        int high = 0;
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, a[i]);
        }
        int k = Integer.parseInt(f.readLine());
        if(k == 1) {
            out.println(high);
        } else {
            int low = 1;
            int ans = 0;
            while(low <= high) {
                int mid = (low+high)/2;
                long temp = 0;
                for(int i: a) {
                    if(i > mid) {
                        temp += (i-mid+k-2)/(k-1);
                    }
                }
                if(temp > mid) {
                    low = mid+1;
                } else {
                    ans = mid;
                    high = mid-1;
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}