import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException{
                //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
                BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
                int n = Integer.parseInt(f.readLine());
                StringTokenizer st = new StringTokenizer(f.readLine());
                int[] l = new int[n];
                for(int i = 0; i < n; i++) {
                        l[i] = Integer.parseInt(st.nextToken());
                }
                st = new StringTokenizer(f.readLine());
                int[][] occ = new int[100001][201];
                for(int i = 0; i < n; i++) {
                        int d = Integer.parseInt(st.nextToken());
                        occ[l[i]][d]++;
                        occ[l[i]][0]++;
                }
                int[] suff = new int[100001];
                for(int i = 99999; i >= 0; i--) {
                        suff[i] = suff[i+1];
                        for(int j = 1; j <= 200; j++) {
                                suff[i] += j*occ[i+1][j];
                        }
                }
                int[] cur = new int[201];
                int curTotal = 0;
                int min = Integer.MAX_VALUE;
                for(int i = 0; i <= 100000; i++) {
                        int remove = curTotal-occ[i][0]+1;
                        int sum = 0;
                        for(int j = 1; j <= 200 && remove > 0; j++) {
                                int take = Math.min(remove, cur[j]);
                                remove -= take;
                                sum += j*take;
                        }
                        min = Math.min(min, sum+suff[i]);
                        for(int j = 1; j <= 200; j++) {
                                cur[j] += occ[i][j];
                        }
                        curTotal += occ[i][0];
                }
                out.println(min);
                f.close();
                out.close();
    }
}
