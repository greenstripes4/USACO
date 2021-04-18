import java.io.*;
import java.util.*;

public class Main {
    private static void helper(int[][] arr, int r) {
        for(int i = 0; i < arr[r].length; i++) {
            arr[r][i] ^= 1;
        }
    }
    private static int solve(int[][] arr) {
        int ans = 0;
        for(int i = 0; i < arr[0].length; i++) {
            int ones = 0;
            for(int[] j: arr) {
                if(j[i] == 1) {
                    ones++;
                }
            }
            ans += Math.max(ones, arr.length-ones);
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[][] arr = new int[R][C];
            for(int i = 0; i < R; i++) {
                st = new StringTokenizer(f.readLine());
                for(int j = 0; j < C; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int ans = 0;
            for(int i = 0; i < (1 << R); i++) {
                for(int j = 0; j < R; j++) {
                    if((i&(1 << j)) > 0) {
                        helper(arr, j);
                    }
                }
                ans = Math.max(ans, solve(arr));
                for(int j = 0; j < R; j++) {
                    if((i&(1 << j)) > 0) {
                        helper(arr, j);
                    }
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}