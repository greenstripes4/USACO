import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        for(int t = 0; t < N; t++) {
            int[][] wall = new int[9][];
            for(int i = 0; i < 9; i++) {
                wall[i] = new int[i+1];
            }
            for(int i = 0; i < 9; i += 2) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                for(int j = 0; j <= i; j += 2) {
                    wall[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i = 2; i < 9; i += 2) {
                for(int j = 1; j <= i; j += 2) {
                    wall[i][j] = (wall[i-2][j-1]-wall[i][j-1]-wall[i][j+1])/2;
                }
            }
            for(int i = 1; i < 9; i += 2) {
                for(int j = 0; j <= i; j++) {
                    wall[i][j] = wall[i+1][j]+wall[i+1][j+1];
                }
            }
            for(int i = 0; i < 9; i++) {
                out.print(wall[i][0]);
                for(int j = 1; j <= i; j++) {
                    out.print(" " + wall[i][j]);
                }
                out.println();
            }
        }
        f.close();
        out.close();
    }
}
