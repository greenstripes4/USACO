import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
                //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
                //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));
                StringTokenizer st = new StringTokenizer(f.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                long[][] arr = new long[n][4];
                for(int i = 0; i < n; i++) {
                        st = new StringTokenizer(f.readLine());
                        int l = Integer.parseInt(st.nextToken());
                        int[] pref = new int[l+1];
                        long max = Long.MIN_VALUE;
                        long min = 0;
                        for(int j = 1; j <= l; j++) {
                                pref[j] = pref[j-1]+Integer.parseInt(st.nextToken());
                                max = Math.max(max, pref[j]-min);
                                min = Math.min(min, pref[j]);
                        }
                        arr[i][0] = pref[l];
                        arr[i][1] = Integer.MIN_VALUE;
                        for(int j = 1; j <= l; j++) {
                                arr[i][1] = Math.max(arr[i][1], pref[j]);
                        }
                        arr[i][2] = Integer.MIN_VALUE;
                        for(int j = 0; j < l; j++) {
                                arr[i][2] = Math.max(arr[i][2], pref[l]-pref[j]);
                        }
                        arr[i][3] = max;
                }
                st = new StringTokenizer(f.readLine());
                long[][] concat = new long[m][3];
                long max = Long.MIN_VALUE;
                for(int i = 0; i < m; i++) {
                        concat[i] = arr[Integer.parseInt(st.nextToken())-1];
                        max = Math.max(max, concat[i][3]);
                }
                long cur = concat[0][2];
                for(int i = 1; i < m; i++) {
                        max = Math.max(max, cur+concat[i][1]);
                        cur = Math.max(cur+concat[i][0], concat[i][2]);
                }
                out.println(max);
                f.close();
                out.close();
        }
}
