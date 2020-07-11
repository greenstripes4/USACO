import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("pails.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] attainable = new boolean[X+1][Y+1];
        attainable[0][0] = true;
        for(int operationNum = 0; operationNum < K; operationNum++) {
            boolean[][] next = new boolean[X+1][Y+1];
            for(int i = 0; i < attainable.length; i++) {
                for(int j = 0; j < attainable[i].length; j++) {
                    if(!attainable[i][j]) continue;
                    next[i][j] = true;
                    next[0][j] = true;
                    next[X][j] = true;
                    next[i][0] = true;
                    next[i][Y] = true;
                    int moveRight = Math.min(i, Y - j);
                    next[i-moveRight][j+moveRight] = true;
                    int moveLeft = Math.min(X - i, j);
                    next[i+moveLeft][j-moveLeft] = true;
                }
            }
            attainable = next;
        }
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < attainable.length; i++) {
            for(int j = 0; j < attainable[i].length; j++) {
                if(!attainable[i][j]) continue;
                ret = Math.min(ret, Math.abs(i+j-M));
            }
        }
        out.println(ret);
        f.close();
        out.close();
    }
}
