import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            char[][] grid = new char[M][N];
            for(int i = 0; i < M; i++) {
                grid[i] = f.readLine().toCharArray();
            }
            out.println(M + " " + N + " " + Q);
            for(int i = 0; i < Q; i++) {
                StringTokenizer query = new StringTokenizer(f.readLine());
                int r = Integer.parseInt(query.nextToken());
                int c = Integer.parseInt(query.nextToken());
                int maximumSideLength = -1;
                while(true) {
                    maximumSideLength += 2;
                    int startRow = r-maximumSideLength/2;
                    int endRow = r+maximumSideLength/2;
                    int startColumn = c-maximumSideLength/2;
                    int endColumn = c+maximumSideLength/2;
                    if(startRow < 0 || endRow >= M || startColumn < 0 || endColumn >= N) {
                        break;
                    }
                    boolean validSideLength = true;
                    for(int j = startRow; j <= endRow; j++) {
                        if(grid[j][startColumn] != grid[r][c] || grid[j][endColumn] != grid[r][c]) {
                            validSideLength = false;
                            break;
                        }
                    }
                    for(int j = startColumn; j <= endColumn; j++) {
                        if(grid[startRow][j] != grid[r][c] || grid[endRow][j] != grid[r][c]) {
                            validSideLength = false;
                            break;
                        }
                    }
                    if(!validSideLength) {
                        break;
                    }
                }
                out.println(maximumSideLength-2);
            }
        }
        f.close();
        out.close();
    }
}
