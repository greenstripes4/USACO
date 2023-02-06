/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.util.*;

public class Main{
    public static void dfs(char[][] graph, int i, int j){
        if(i<0 || j<0 || i>=graph.length || j>=graph[0].length || graph[i][j]=='#') return;
        graph[i][j] = '#';
        dfs(graph, i+1, j);
        dfs(graph, i-1, j);
        dfs(graph, i, j+1);
        dfs(graph, i, j-1);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("loan.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int length = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        char[][] graph = new char[length][width];
        for(int i = 0; i < length; i++){
            graph[i] = f.readLine().toCharArray();
        }
        int count = 0;
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                if(graph[i][j] == '.') {
                    count++;
                    dfs(graph, i, j);
                }
            }
        }
        out.println(count);
        out.close();
        f.close();
    }
}
