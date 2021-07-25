import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[][] prefixSum = new int[n+1][201];
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                for(int j = 1; j <= 200; j++) {
                    prefixSum[i+1][j] = prefixSum[i][j]+(a[i] == j ? 1 : 0);
                }
            }
            int max = 0;
            for(int x = 1; x <= 200; x++) {
                int i = 0;
                int j = n-1;
                int left = 0;
                int right = 0;
                while(i <= j) {
                    int mid = 0;
                    for(int k = 1; k <= 200; k++) {
                        mid = Math.max(mid, prefixSum[j+1][k]-prefixSum[i][k]);
                    }
                    max = Math.max(max, left+right+mid);
                    while(i < j && a[i] != x) {
                        i++;
                    }
                    while(j > i && a[j] != x) {
                        j--;
                    }
                    i++;
                    j--;
                    left++;
                    right++;
                }
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}