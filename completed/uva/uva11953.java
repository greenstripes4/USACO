/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.util.*;

public class Main{
    public static void dfs(char[][] grid, int i, int j){
        if(i >= grid.length || i < 0 || j >= grid.length || j < 0 || grid[i][j] == '.'){
            return;
        }
        grid[i][j] = '.';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("loan.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCases = Integer.parseInt(f.readLine());
        for(int c = 0; c < testCases; c++){
            int N = Integer.parseInt(f.readLine());
            char[][] grid = new char[N][N];
            for(int i = 0; i < N; i++){
                grid[i] = f.readLine().toCharArray();
            }
            int count = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(grid[i][j] == 'x'){
                        count++;
                        dfs(grid,i,j);
                    }
                }
            }
            out.println("Case " + (c+1) + ": " + count);
        }
        out.close();
        f.close();
    }
}
