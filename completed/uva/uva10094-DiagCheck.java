import java.io.*;
import java.util.*;

public class Main{
    private static int[] solution;
    private static boolean solve(int col, int n, boolean[] usedRow, boolean[] usedDiagonal1, boolean[] usedDiagonal2) {
        if(col == n) {
            return true;
        }
        for(int i = 1; i <= n; i++) {
            if(!usedRow[i] && !usedDiagonal1[i-col+n] && !usedDiagonal2[col-i+n]) {
                solution[col] = i;
                usedRow[i] = true;
                usedDiagonal1[i-col+n] = true;
                usedDiagonal2[col-i+n] = true;
                if(solve(col+1, n, usedRow, usedDiagonal1, usedDiagonal2)) {
                    return true;
                }
                solution[col] = 0;
                usedRow[i] = false;
                usedDiagonal1[i-col+n] = false;
                usedDiagonal2[col-i+n] = false;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            int n = Integer.parseInt(input);
            solution = new int[n];
            if(solve(0, n, new boolean[n+1], new boolean[n*2+1], new boolean[n*2+1])) {
                out.print(solution[0]);
                for(int i = 1; i < n; i++) {
                    out.print(" " + solution[i]);
                }
                out.println();
            } else {
                out.println("Impossible");
            }
        }
        f.close();
        out.close();
    }
}
