import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] x = new int[n];
        for(int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }
        char[][] board = new char[Math.max(b, d)][a+c];
        int startC = b < d ? 0 : a;
        int endC = b < d ? a : a+c;
        int startR = Math.min(b, d);
        int endR = Math.max(b, d);
        for(int i = startR; i < endR; i++) {
            for(int j = startC; j < endC; j++) {
                board[i][j] = '.';
            }
        }
        int curC = b < d ? b%2 == 1 ? 0 : a+c-1 : d%2 == 0 ? 0 : a+c-1;
        int curR = 0;
        int dirC = b < d ? b%2 == 1 ? 1 : -1 : d%2 == 0 ? 1 : -1;
        for(int i = 0; i < n; i++) {
            char cur = (char) ('a'+i);
            for(int j = 0; j < x[i]; j++) {
                board[curR][curC] = cur;
                if(curC+dirC < 0 || curC+dirC >= a+c) {
                    curR++;
                    dirC = -dirC;
                } else {
                    curC += dirC;
                }
                while(curR < endR && board[curR][curC] == '.') {
                    if(curC+dirC < 0 || curC+dirC >= a+c) {
                        curR++;
                        dirC = -dirC;
                    } else {
                        curC += dirC;
                    }
                }
            }
        }
        out.println("YES");
        for(char[] i: board) {
            out.println(i);
        }
        f.close();
        out.close();
    }
}
