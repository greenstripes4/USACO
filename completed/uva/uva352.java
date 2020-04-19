import java.io.*;
import java.util.*;

public class Main{
    private static void dfs(char[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
        dfs(grid,r-1,c-1);
        dfs(grid,r-1,c+1);
        dfs(grid,r+1,c-1);
        dfs(grid,r+1,c+1);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        int testCase = 1;
        while((input = f.readLine()) != null){
            int n = Integer.parseInt(input);
            char[][] arr = new char[n][n];
            for(int i = 0; i < n; i++){
                arr[i] = f.readLine().toCharArray();
            }
            int count = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(arr[i][j] == '1'){
                        count++;
                        dfs(arr,i,j);
                    }
                }
            }
            out.println("Image number " + testCase + " contains " + count + " war eagles.");
            testCase++;
        }
        f.close();
        out.close();
    }
}
