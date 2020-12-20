import java.io.*;
import java.util.*;

public class Main{
    private static int[] solution;
    private static boolean canPlace(int col, int row) {
        for(int i = 0; i < col; i++) {
            if(Math.abs(row-solution[i]) == col-i) {
                return false;
            }
        }
        return true;
    }
    private static boolean solve(int col, int n, boolean[] used) {
        if(col == n) {
            return true;
        }
        for(int i = 1; i <= n; i++) {
            if(!used[i] && canPlace(col, i)) {
                solution[col] = i;
                used[i] = true;
                if(solve(col+1, n, used)) {
                    return true;
                }
                solution[col] = 0;
                used[i] = false;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            int n = Integer.parseInt(input);
            solution = new int[n];
            if(solve(0, n, new boolean[n+1])) {
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
