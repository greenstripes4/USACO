/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("loan.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[][] grid = new int[R][C];
            int rows = Integer.parseInt(f.readLine());
            for (int i = 0; i < rows; i++) {
                StringTokenizer row = new StringTokenizer(f.readLine());
                int rowNumber = Integer.parseInt(row.nextToken());
                int bombs = Integer.parseInt(row.nextToken());
                for (int j = 0; j < bombs; j++) {
                    grid[rowNumber][Integer.parseInt(row.nextToken())] = 1;
                }
            }
            StringTokenizer start = new StringTokenizer(f.readLine());
            int[] strt = {Integer.parseInt(start.nextToken()),Integer.parseInt(start.nextToken())};
            StringTokenizer end = new StringTokenizer(f.readLine());
            int[] ed = {Integer.parseInt(end.nextToken()),Integer.parseInt(end.nextToken())};
            Queue<int[]> queue = new LinkedList<>();
            queue.add(strt);
            grid[strt[0]][strt[1]] = 1;
            int steps = 0;
            boolean found = false;
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int[] temp = queue.poll();
                    if(temp[0] == ed[0] && temp[1] == ed[1]){
                        found = true;
                        break;
                    }
                    int[][] fourDir = {{1,0},{-1,0},{0,1},{0,-1}};
                    for(int[] j: fourDir){
                        if(temp[0]+j[0] >= 0 && temp[0]+j[0] < grid.length && temp[1]+j[1] >= 0 && temp[1]+j[1] < grid.length && grid[temp[0]+j[0]][temp[1]+j[1]] == 0){
                            queue.add(new int[]{temp[0]+j[0],temp[1]+j[1]});
                            grid[temp[0]+j[0]][temp[1]+j[1]] = 1;
                        }
                    }
                }
                if(found){
                    break;
                }
                steps++;
            }
            out.println(steps);
        }
        out.close();
        f.close();
    }
}
