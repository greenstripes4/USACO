import java.io.*;
import java.util.*;

public class Main {
    private static char[][] arr;
    private static boolean[][] vis;
    private static int count;
    private static void fill(int r, int c) {
        if(r < 0 || c < 0 || r >= arr.length || c >= arr[0].length || arr[r][c] == '#' || vis[r][c]) {
            return;
        }
        vis[r][c] = true;
        count++;
        fill(r-1, c);
        fill(r+1, c);
        fill(r, c-1);
        fill(r, c+1);
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            arr = new char[N][];
            int r = -1;
            int c = -1;
            for (int i = 0; i < N; i++) {
                arr[i] = f.readLine().toCharArray();
                for(int j = 0; j < M; j++) {
                    if(arr[i][j] == '@') {
                        arr[i][j] = '.';
                        r = i;
                        c = j;
                    }
                }
            }
            vis = new boolean[N][M];
            count = 0;
            fill(r, c);
            out.println(count);
        }
        f.close();
        out.close();
    }
}