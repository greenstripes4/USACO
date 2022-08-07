import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] b = new int[n];
        for(int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(b);
        for(int i = 0; i < n/2; i++) {
            int temp = b[i];
            b[i] = b[n-i-1];
            b[n-i-1] = temp;
        }
        st = new StringTokenizer(f.readLine());
        int[] p = new int[m];
        for(int i = 0; i < m; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(p);
        int low = 0;
        int high = Math.min(n, m);
        int ans = 0;
        while(low <= high) {
            int mid = (low+high)/2;
            long need = 0;
            for(int i = 0; i < mid; i++) {
                need += Math.max(0, p[i]-b[mid-i-1]);
            }
            if(need <= a) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        long sum = 0;
        for(int i = 0; i < ans; i++) {
            sum += p[i];
        }
        out.println(ans + " " + Math.max(0, sum-a));
        f.close();
        out.close();
    }
}