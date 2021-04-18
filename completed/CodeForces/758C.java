import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        int x = Integer.parseInt(st.nextToken())-1;
        int y = Integer.parseInt(st.nextToken())-1;
        long[][] arr = new long[n][m];
        if(n > 1) {
            long temp = k/(2*n*m-2*m)*2;
            Arrays.fill(arr[0], temp/2);
            for(int i = 1; i < n-1; i++) {
                Arrays.fill(arr[i], temp);
            }
            Arrays.fill(arr[n-1], temp/2);
            k %= 2*n*m-2*m;
            int temp2 = (int) (k/m);
            for(int i = 0; i <= Math.min(n-1, temp2-1); i++) {
                for(int j = 0; j < m; j++) {
                    arr[i][j]++;
                }
            }
            int next = temp2 == n ? n-2 : temp2;
            temp2 -= n;
            if(temp2 > 0) {
                next = n-temp2-2;
                for(int i = n-2; i >= n-temp2-1; i--) {
                    for(int j = 0; j < m; j++) {
                        arr[i][j]++;
                    }
                }
            }
            k %= m;
            for(int i = 0; i < k; i++) {
                arr[next][i]++;
            }
        } else {
            Arrays.fill(arr[0], k/m);
            for(int i = 0; i < k%m; i++) {
                arr[0][i]++;
            }
        }
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for(long[] i: arr) {
            for(long j: i) {
                min = Math.min(min, j);
                max = Math.max(max, j);
            }
        }
        out.println(max + " " + min + " " + arr[x][y]);
        f.close();
        out.close();
    }
}