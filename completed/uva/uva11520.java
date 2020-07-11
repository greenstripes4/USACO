import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 1; t <= testcases; t++) {
            int n = Integer.parseInt(f.readLine());
            char[][] matrix = new char[n][n];
            for(int i = 0; i < n; i++) {
                matrix[i] = f.readLine().toCharArray();
            }
            char[] alphabet = {'A','B','C','D','E','F','G','H','I','J'};
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(matrix[i][j] == '.') {
                        char above = i > 0 ? matrix[i-1][j] : '.';
                        char below = i < n-1 ? matrix[i+1][j] : '.';
                        char left = j > 0 ? matrix[i][j-1] : '.';
                        char right = j < n-1 ? matrix[i][j+1] : '.';
                        for(char k: alphabet) {
                            if(k != above && k != below && k != left && k != right) {
                                matrix[i][j] = k;
                                break;
                            }
                        }
                    }
                }
            }
            out.println("Case " + t + ":");
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    out.print(matrix[i][j]);
                }
                out.println();
            }
        }
        f.close();
        out.close();
    }
}
