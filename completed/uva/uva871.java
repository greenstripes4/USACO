import java.io.*;
import java.util.*;

public class Main{
    private static int size;
    private static void dfs(ArrayList<char[]> grid, int r, int c) {
        if(r < 0 || r >= grid.size() || c < 0 || c >= grid.get(0).length || grid.get(r)[c] == '0') {
            return;
        }
        size++;
        grid.get(r)[c] = '0';
        dfs(grid,r-1,c-1);
        dfs(grid,r-1,c);
        dfs(grid,r-1,c+1);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
        dfs(grid,r+1,c-1);
        dfs(grid,r+1,c);
        dfs(grid,r+1,c+1);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        f.readLine();
        for(int t = 0; t < testcases; t++) {
            if(t > 0) {
                out.println();
            }
            ArrayList<char[]> grid = new ArrayList<>();
            String input;
            while((input = f.readLine()) != null && input.length() > 0) {
                grid.add(input.toCharArray());
            }
            int max = 0;
            for(int i = 0; i < grid.size(); i++) {
                for(int j = 0; j < grid.get(i).length; j++) {
                    if(grid.get(i)[j] == '1') {
                        size = 0;
                        dfs(grid,i,j);
                        max = Math.max(max,size);
                    }
                }
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}
