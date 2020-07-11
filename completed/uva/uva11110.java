import java.io.*;
import java.util.*;

public class Main{
    private static int size;
    private static void floodFill(int[][] a, int r, int c, int tar) {
        if(r < 0 || r >= a.length || c < 0 || c >= a[0].length || a[r][c] != tar) {
            return;
        }
        a[r][c] = -1;
        size++;
        floodFill(a,r-1,c,tar);
        floodFill(a,r+1,c,tar);
        floodFill(a,r,c-1,tar);
        floodFill(a,r,c+1,tar);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int n = Integer.parseInt(f.readLine());
            if(n == 0) {
                break;
            }
            int[][] a = new int[n][n];
            for(int i = 1; i <= n-1; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                while(st.hasMoreTokens()) {
                    int r = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    a[r-1][c-1] = i;
                }
            }
            boolean finished = false;
            boolean[] seen = new boolean[n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(a[i][j] >= 0) {
                        if(seen[a[i][j]]) {
                            out.println("wrong");
                            finished = true;
                            break;
                        }
                        seen[a[i][j]] = true;
                        size = 0;
                        floodFill(a,i,j,a[i][j]);
                        if(size != n) {
                            out.println("wrong");
                            finished = true;
                            break;
                        }
                    }
                }
                if(finished) {
                    break;
                }
            }
            if(!finished) {
                boolean good = true;
                for (int i = 0; i < n; i++) {
                    if (!seen[i]) {
                        good = false;
                        break;
                    }
                }
                out.println(good ? "good" : "wrong");
            }
        }
        f.close();
        out.close();
    }
}
