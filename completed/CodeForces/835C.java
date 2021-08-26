import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][][] prefSum = new int[101][101][c+1];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            prefSum[x][y][s]++;
        }
        for(int i = 0; i <= 100; i++) {
            for(int j = 0; j <= 100; j++) {
                for(int k = 0; k <= c; k++) {
                    if(i > 0) {
                        prefSum[i][j][k] += prefSum[i-1][j][k];
                    }
                    if(j > 0) {
                        prefSum[i][j][k] += prefSum[i][j-1][k];
                    }
                    if(i > 0 && j > 0) {
                        prefSum[i][j][k] -= prefSum[i-1][j-1][k];
                    }
                }
            }
        }
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(f.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int sum = 0;
            for(int k = 0; k <= c; k++) {
                int occ = prefSum[x2][y2][k]-prefSum[x2][y1-1][k]-prefSum[x1-1][y2][k]+prefSum[x1-1][y1-1][k];
                sum += occ*((k+t)%(c+1));
            }
            out.println(sum);
        }
        f.close();
        out.close();
    }
}
