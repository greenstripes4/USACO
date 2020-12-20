import java.io.*;
import java.util.*;

public class program {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] nest = new int[N][M];
        for(int i = 0; i < N; i++) {
            StringTokenizer row = new StringTokenizer(f.readLine());
            for(int j = 0; j < M; j++) {
                nest[i][j] = Integer.parseInt(row.nextToken());
            }
        }
        for(int i = 0; i < M; i++) {
            out.print(nest[0][i]);
            for(int j = 1; j < N; j++) {
                out.print(" " + nest[j][i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
