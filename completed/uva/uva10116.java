import java.io.*;
import java.util.*;

public class Main{
    private static int getLoopLength(HashMap<String,String> seen, String root){
        String next = seen.get(root);
        int steps = 1;
        while(!next.equals(root)){
            next = seen.get(next);
            steps++;
        }
        return steps;
    }
    private static void dfs(char[][] grid, int r, int c, int steps, HashMap<String,String> seen, PrintWriter out){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length){
            out.println(steps + " step(s) to exit");
            return;
        }
        if(seen.containsKey(r + " " + c)){
            int loopLength = getLoopLength(seen,r + " " + c);
            out.println((steps - loopLength) + " step(s) before a loop of " + loopLength + " step(s)");
            return;
        }
        if(grid[r][c] == 'N'){
            seen.put(r + " " + c, (r-1) + " " + c);
            dfs(grid,r-1,c,steps+1,seen,out);
            return;
        }
        if(grid[r][c] == 'S'){
            seen.put(r + " " + c, (r+1) + " " + c);
            dfs(grid,r+1,c,steps+1,seen,out);
            return;
        }
        if(grid[r][c] == 'E'){
            seen.put(r + " " + c, r + " " + (c+1));
            dfs(grid,r,c+1,steps+1,seen,out);
            return;
        }
        seen.put(r + " " + c, r + " " + (c-1));
        dfs(grid,r,c-1,steps+1,seen,out);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int rows = Integer.parseInt(st.nextToken());
            int columns = Integer.parseInt(st.nextToken());
            int entryPoint = Integer.parseInt(st.nextToken());
            if(rows == 0 && columns == 0 && entryPoint == 0){
                break;
            }
            char[][] grid = new char[rows][columns];
            for(int i = 0; i < rows; i++){
                grid[i] = f.readLine().toCharArray();
            }
            dfs(grid,0,entryPoint-1,0,new HashMap<>(),out);
        }
        f.close();
        out.close();
    }
}
