import java.io.*;
import java.util.*;

public class Main{
    static int max = 0;
    static char[][] grid;
    public static void recur(int i, int j, int open, int closed){
        char original = grid[i][j];
        if(closed > 0 && grid[i][j] == '('){
            return;
        }
        if(grid[i][j] == '('){
            open++;
        } else {
            closed++;
        }
        grid[i][j] = '.';
        if(open == closed){
            max = Math.max(max,open+closed);
            grid[i][j] = original;
            return;
        }
        if(i+1 < grid.length && grid[i+1][j] != '.'){
            recur(i+1,j,open,closed);
        }
        if(i-1 >= 0 && grid[i-1][j] != '.'){
            recur(i-1,j,open,closed);
        }
        if(j+1 < grid.length && grid[i][j+1] != '.'){
            recur(i,j+1,open,closed);

        }
        if(j-1 >= 0 && grid[i][j-1] != '.'){
            recur(i,j-1,open,closed);
        }
        grid[i][j] = original;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("hshoe.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hshoe.out")));
        int length = Integer.parseInt(f.readLine());
        max = 0;
        grid = new char[length][length];
        for(int i = 0; i < length; i++){
            grid[i] = f.readLine().toCharArray();
        }
        if(grid[0][0] == ')'){
            out.println(0);
        } else {
            recur(0, 0, 0, 0);
            out.println(max);
        }
        out.close();
        f.close();
    }
}
