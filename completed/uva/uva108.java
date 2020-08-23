import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = f.nextInt();
        int[][] grid = new int[n][n];
        for (int y = 0; y < n; y++) for (int z = 0; z < n; z++) {
            grid[y][z] = f.nextInt();
            if (z > 0) {
                grid[y][z] += grid[y][z-1];
            }
        }
        int maxSubRect = -127*100*100;
        int subRect;
        for(int l = 0; l < n; l++) {
            for(int r = l; r < n; r++) {
                subRect = 0;
                for(int row = 0; row < n; row++) {
                    if(l > 0) {
                        subRect += grid[row][r]-grid[row][l-1];
                    } else {
                        subRect += grid[row][r];
                    }
                    if(subRect < 0) {
                        subRect = 0;
                    }
                    maxSubRect = Math.max(maxSubRect, subRect);
                }
            }
        }
        out.println(maxSubRect);
        f.close();
        out.close();
    }
}
