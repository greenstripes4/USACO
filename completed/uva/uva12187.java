import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            if(N == 0 && R == 0 && C == 0 && K == 0) {
                break;
            }
            int[][] arr = new int[R][C];
            for(int i = 0; i < R; i++) {
                st = new StringTokenizer(f.readLine());
                for(int j = 0; j < C; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[] dr = {-1, 0, 0, 1};
            int[] dc = {0, -1, 1, 0};
            for(int k = 0; k < K; k++) {
                int[][] next = new int[R][C];
                for(int i = 0; i < R; i++) {
                    for(int j = 0; j < C; j++) {
                        boolean flag = false;
                        for(int d = 0; d < 4; d++) {
                            int l = i+dr[d];
                            int m = j+dc[d];
                            if(l >= 0 && l < R && m >= 0 && m < C && (arr[l][m]+1)%N == arr[i][j]) {
                                flag = true;
                                next[i][j] = arr[l][m];
                                break;
                            }
                        }
                        if(!flag) {
                            next[i][j] = arr[i][j];
                        }
                    }
                }
                arr = next;
            }
            for(int i = 0; i < R; i++) {
                out.print(arr[i][0]);
                for(int j = 1; j < C; j++) {
                    out.print(" " + arr[i][j]);
                }
                out.println();
            }
        }
        f.close();
        out.close();
    }
}