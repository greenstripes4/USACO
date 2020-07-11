import java.io.*;
import java.util.*;

public class Main{
    private static void dfs(ArrayList<char[]> maze, int r, int c) {
        if(r < 0 || r >= maze.size() || c < 0 || c >= maze.get(r).length || (maze.get(r)[c] >= 'A' && maze.get(r)[c] <= 'Z') || maze.get(r)[c] == '#') {
            return;
        }
        maze.get(r)[c] = '#';
        dfs(maze,r+1,c);
        dfs(maze,r-1,c);
        dfs(maze,r,c+1);
        dfs(maze,r,c-1);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++) {
            ArrayList<char[]> maze = new ArrayList<>();
            String input;
            while((input = f.readLine()).charAt(0) != '_') {
                maze.add(input.toCharArray());
            }
            for(int i = 0; i < maze.size(); i++) {
                for(int j = 0; j < maze.get(i).length; j++) {
                    if(maze.get(i)[j] == '*') {
                        dfs(maze,i,j);
                    }
                }
            }
            for(char[] i: maze) {
                out.println(i);
            }
            out.println(input);
        }
        f.close();
        out.close();
    }
}
