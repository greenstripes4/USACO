/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.util.*;

public class Main{
    static PrintWriter out;
    public static ArrayList<Character> getPath(char[][] graph, int i, int j){
        ArrayList<Character> ans = new ArrayList<>();
        while(graph[i][j] != 'A'){
            ans.add(0,graph[i][j]);
            if(graph[i][j] == 'D'){
                i--;
            } else if(graph[i][j] == 'U'){
                i++;
            } else if(graph[i][j] == 'R'){
                j--;
            } else {
                j++;
            }
        }
        return ans;
    }
    public static void printPath(char[][] graph, boolean[][] visited, int i, int j){
        Queue<Integer> queue = new LinkedList<>();
        int steps = 0;
        queue.add(i<<16 | j);
        while(!queue.isEmpty()){
            int size = queue.size();
            steps++;
            for(int k = 0; k < size; k++){
                int temp = queue.poll();
                int x=temp&0xffff, y=temp>>16;
                if(y+1 < graph.length){
                    if(graph[y+1][x] == '.'){
                        graph[y+1][x] = 'D';
                        queue.add((y+1)<<16 | x);
                    } else if(graph[y+1][x] == 'B'){
                        graph[y+1][x] = 'D';
                        ArrayList<Character> ans = getPath(graph,y+1,x);
                        out.println("YES");
                        out.println(steps);
                        for(char l: ans){
                            out.print(l);
                        }
                        out.println();
                        return;
                    }
                }
                if(y > 0){
                    if(graph[y-1][x] == '.') {
                        graph[y-1][x] = 'U';
                        queue.add((y-1)<<16 | x);
                    } else if(graph[y-1][x] == 'B'){
                        graph[y-1][x] = 'U';
                        ArrayList<Character> ans = getPath(graph,y-1,x);
                        out.println("YES");
                        out.println(steps);
                        for(char l: ans){
                            out.print(l);
                        }
                        out.println();
                        return;
                    }
                }
                if(x+1 < graph[0].length){
                    if(graph[y][x+1] == '.'){
                        graph[y][x+1] = 'R';
                        queue.add(y<<16 | (x+1));
                    } else if(graph[y][x+1] == 'B'){
                        graph[y][x+1] = 'R';
                        ArrayList<Character> ans = getPath(graph,y,x+1);
                        out.println("YES");
                        out.println(steps);
                        for(char l: ans){
                            out.print(l);
                        }
                        out.println();
                        return;
                    }
                }
                if(x > 0){
                    if(graph[y][x-1] == '.'){
                        graph[y][x-1] = 'L';
                        queue.add(y<<16 | (x-1));
                    } else if(graph[y][x-1] == 'B'){
                        graph[y][x-1] = 'L';
                        ArrayList<Character> ans = getPath(graph,y,x-1);
                        out.println("YES");
                        out.println(steps);
                        for(char l: ans){
                            out.print(l);
                        }
                        out.println();
                        return;
                    }
                }
            }
        }
        out.println("NO");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("test_input.txt"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int length = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        char[][] graph = new char[length][width];
        for(int i = 0; i < length; i++){
            graph[i] = f.readLine().toCharArray();
        }
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                if(graph[i][j] == 'A'){
                    printPath(graph,new boolean[graph.length][graph[0].length],i,j);
                }
            }
        }
        out.close();
        f.close();
    }
}
