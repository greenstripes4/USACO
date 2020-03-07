/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.util.*;

public class Main{
    public static int bfs(char[][] grid, int i, int j, char land, char water){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        int steps = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0; k < size; k++){
                int[] temp = queue.poll();
                steps++;
                grid[temp[0]][temp[1]] = water;
                for(int[] l: dir){
                    int[] next = new int[]{temp[0]+l[0],((temp[1]+l[1])+grid[0].length)%grid[0].length};
                    if(next[0] >= 0 && next[0] < grid.length && next[1] >= 0 && next[1] < grid[0].length && grid[next[0]][next[1]] == land){
                        boolean contains = false;
                        for(int[] m: queue){
                            if(Arrays.equals(m,next)){
                                contains = true;
                                break;
                            }
                        }
                        if(!contains) {
                            queue.add(next);
                        }
                    }
                }
            }
        }
        return steps;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null){
            StringTokenizer st = new StringTokenizer(input);
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            char[][] map = new char[M][N];
            for(int i = 0; i < M; i++){
                map[i] = f.readLine().toCharArray();
            }
            StringTokenizer currentTerritory = new StringTokenizer(f.readLine());
            int row = Integer.parseInt(currentTerritory.nextToken());
            int column = Integer.parseInt(currentTerritory.nextToken());
            char land = map[row][column];
            char water = '\\';
            for(int i = 0; i < map.length; i++){
                for(int j = 0; j < map[0].length; j++){
                    if(map[i][j] != land){
                        water = map[i][j];
                        break;
                    }
                }
            }
            bfs(map,row,column,land,water);
            int max = 0;
            for(int i = 0; i < M; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] == land){
                        max = Math.max(bfs(map,i,j,land,water),max);
                    }
                }
            }
            out.println(max);
            f.readLine();
        }
        out.close();
        f.close();
    }
}
