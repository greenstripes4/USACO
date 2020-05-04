import java.io.*;
import java.util.*;

public class Main{
    public static void dfs(char[][] grid, int r, int c, String path, PrintWriter out){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || "@#IEHOVA".indexOf(grid[r][c]) < 0){
            return;
        }
        if(grid[r][c] == '#'){
            out.println(path.substring(0,path.length()-1));
            return;
        }
        grid[r][c] = 'Z';
        dfs(grid,r-1,c,path+"forth ",out);
        dfs(grid,r,c-1,path+"left ",out);
        dfs(grid,r,c+1,path+"right ",out);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCases = Integer.parseInt(f.readLine());
        for(int i = 0; i < testCases; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            char[][] grid = new char[m][n];
            for(int j = 0; j < m; j++){
                grid[j] = f.readLine().toCharArray();
            }
            int r = -1;
            int c = -1;
            for(int j = 0; j < m; j++){
                for(int k = 0; k < n; k++){
                    if(grid[j][k] == '@'){
                        r = j;
                        c = k;
                        break;
                    }
                }
                if(r >= 0){
                    break;
                }
            }
            dfs(grid,r,c,"",out);
        }
        f.close();
        out.close();
    }
}
