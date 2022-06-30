import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken())-1;
            }
        }
        int[] map = new int[n];
        for(int i = 0; i < n; i++) {
            map[arr[0][i]] = i;
        }
        int[][] size = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = map[arr[i][j]];
            }
            size[i][arr[i][n-1]] = 1;
            for(int j = n-2; j >= 0; j--) {
                if(arr[i][j] == arr[i][j+1]-1) {
                    size[i][arr[i][j]] = size[i][arr[i][j+1]]+1;
                } else {
                    size[i][arr[i][j]] = 1;
                }
            }
        }
        long ans = 0;
        for(int i = 0; i < n; i++) {
            int min = n;
            for(int j = 0; j < m; j++) {
                min = Math.min(min, size[j][i]);
            }
            ans += min;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}