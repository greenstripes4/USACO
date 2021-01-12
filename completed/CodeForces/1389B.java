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
            int z = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            int[] prefixSum = new int[n+1];
            for(int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken());
                prefixSum[j+1] = prefixSum[j]+a[j];
            }
            int[] bestPair = new int[n];
            for(int j = 1; j < n; j++) {
                bestPair[j] = bestPair[j-1];
                if(j < n-1 && a[j]+a[j+1] > a[bestPair[j]]+a[bestPair[j]+1]) {
                    bestPair[j] = j;
                }
            }
            int max = 0;
            for(int j = 0; j <= z; j++) {
                int l = k-j;
                if(l < j) {
                    continue;
                }
                int m = l-j;
                int left = bestPair[m];
                int sum = prefixSum[m+1]+(a[left]+a[left+1])*j;
                max = Math.max(max, sum);
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}