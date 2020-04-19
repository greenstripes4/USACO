import java.io.*;
import java.util.*;

public class Main{
    private static void dfs(char[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '*'){
            return;
        }
        grid[r][c] = '*';
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
        while(!(input = f.readLine()).equals("0 0")){
            StringTokenizer st = new StringTokenizer(input);
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            char[][] land = new char[m][n];
            for(int i = 0; i < m; i++){
                land[i] = f.readLine().toCharArray();
            }
            int count = 0;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(land[i][j] == '@'){
                        count++;
                        dfs(land,i,j);
                    }
                }
            }
            out.println(count);
        }
        f.close();
        out.close();
    }
}
