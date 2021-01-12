import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            int[][] prefixSums = new int[n+1][26];
            for(int j = 0; j < n; j++) {
                a[j] = Integer.parseInt(st.nextToken())-1;
                for(int k = 0; k < 26; k++) {
                    prefixSums[j+1][k] = prefixSums[j][k];
                }
                prefixSums[j+1][a[j]]++;
            }
            int max = 0;
            for(int j = 0; j < n; j++) {
                for(int k = j; k < n; k++) {
                    int x = 0;
                    int y = 0;
                    for(int l = 0; l < 26; l++) {
                        x = Math.max(x, Math.min(prefixSums[j][l], prefixSums[n][l]-prefixSums[k+1][l]));
                        y = Math.max(y, prefixSums[k+1][l]-prefixSums[j][l]);
                    }
                    max = Math.max(max, 2*x+y);
                }
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}