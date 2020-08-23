import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static int encodeGrid(int[][] g) {
        int code = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                code = code << 1 | g[i][j];
            }
        }
        return code;
    }
    private static int[][] f(int[][] g) {
        int[][] fg = new int[3][3];
        int[][] directions = {{-1,0},{0,-1},{0,1},{1,0}};
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                int sum = 0;
                for(int[] k: directions) {
                    int neighborI = i+k[0];
                    int neighborJ = j+k[1];
                    if(neighborI >= 0 && neighborI < 3 && neighborJ >= 0 && neighborJ < 3) {
                        sum += g[neighborI][neighborJ];
                    }
                }
                fg[i][j] = sum%2;
            }
        }
        return fg;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++) {
            f.readLine();
            int[][] g = new int[3][3];
            for(int i = 0; i < 3; i++) {
                char[] nextRow = f.readLine().toCharArray();
                for(int j = 0; j < 3; j++) {
                    g[i][j] = Character.getNumericValue(nextRow[j]);
                }
            }
            int[] iValues = new int[512];
            Arrays.fill(iValues,-1);
            int i = 0;
            while(iValues[encodeGrid(g)] == -1) {
                iValues[encodeGrid(g)] = i;
                g = f(g);
                i++;
            }
            out.println(iValues[encodeGrid(g)]-1);
        }
        f.close();
        out.close();
    }
}
