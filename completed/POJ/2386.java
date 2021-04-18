import java.io.*;
import java.util.*;

public class Main {
    private static char[][] arr;
    private static void fill(int r, int c) {
        if(r < 0 || c < 0 || r >= arr.length || c >= arr[0].length || arr[r][c] == '.') {
            return;
        }
        arr[r][c] = '.';
        fill(r-1, c-1);
        fill(r-1, c);
        fill(r-1, c+1);
        fill(r+1, c);
        fill(r+1, c-1);
        fill(r+1, c+1);
        fill(r, c-1);
        fill(r, c+1);
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new char[N][];
        for(int i = 0; i < N; i++) {
            arr[i] = f.readLine().toCharArray();
        }
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 'W') {
                    count++;
                    fill(i, j);
                }
            }
        }
        out.println(count);
        f.close();
        out.close();
    }
}