import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            for(int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
            }
            int[] sums = new int[2*k+2];
            int[] prefixSums = new int[2*k+2];
            for(int j = 0; j < n/2; j++) {
                sums[a[j]+a[n-j-1]]++;
                prefixSums[Math.min(a[j], a[n-j-1])+1]++;
                prefixSums[Math.max(a[j], a[n-j-1])+k+1]--;
            }
            for(int j = 2; j <= 2*k; j++) {
                prefixSums[j] += prefixSums[j-1];
            }
            int min = n;
            for(int j = 2; j <= 2*k; j++) {
                min = Math.min(min, prefixSums[j]-sums[j]+2*(n/2-prefixSums[j]));
            }
            out.println(min);
        }
        f.close();
        out.close();
    }
}