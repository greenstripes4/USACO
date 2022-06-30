import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[][] s = new long[1000001][2];
        for(int i = 1; i <= 1000000; i++) {
            s[i][0] = A+(i-1)*B;
            s[i][1] = s[i-1][1]+s[i][0];
        }
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            int l = Integer.parseInt(st.nextToken());
            long t = Integer.parseInt(st.nextToken());
            long m = Integer.parseInt(st.nextToken());
            int low = l;
            int high = 1000000;
            int ans = -1;
            while(low <= high) {
                int mid = (low+high)/2;
                if(s[mid][0] <= t && s[mid][1]-s[l-1][1] <= m*t) {
                    low = mid+1;
                    ans = mid;
                } else {
                    high = mid-1;
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}