import java.io.*;
import java.util.*;

public class program {
    private static int solve(int[][] square) {
        int target = 0;
        int sumDiagonal2 = 0;
        for(int i = 0; i < square.length; i++) {
            target += square[i][i];
            sumDiagonal2 += square[i][square.length-i-1];
        }
        if(target != sumDiagonal2) {
            return 0;
        }
        for(int i = 0; i < square.length; i++) {
            int sumRow = 0;
            int sumCol = 0;
            for(int j = 0; j < square.length; j++) {
                sumRow += square[i][j];
                sumCol += square[j][i];
            }
            if(sumRow != target || sumCol != target) {
                return 0;
            }
        }
        return 1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int Q = Integer.parseInt(f.readLine());
        for(int s = 0; s < Q; s++) {
            int N = Integer.parseInt(f.readLine());
            int[][] square = new int[N][N];
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                for(int j = 0; j < N; j++) {
                    square[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            out.println(solve(square));
        }
        f.close();
        out.close();
    }
}
