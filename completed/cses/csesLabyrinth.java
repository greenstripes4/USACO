/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.util.*;

public class Main{
    public static ArrayList<Character> dfs(char[][] graph, int i, int j, ArrayList<Character> dir){
        if(graph[i][j] == '#') {
            return new ArrayList<>();
        }
        if(graph[i][j] == 'B'){
            return dir;
        }
        graph[i][j] = '#';
        ArrayList<Character> res = new ArrayList<>();
        if(i+1 < graph.length) {
            dir.add('D');
            ArrayList<Character> temp = dfs(graph,i+1,j,dir);
            if((temp.size() > 0 && temp.size() < res.size()) || res.size() == 0){
                res.clear();
                res.addAll(temp);
            }
            dir.remove(dir.size()-1);
        }
        if(i-1 >= 0) {
            dir.add('U');
            ArrayList<Character> temp = dfs(graph,i-1,j,dir);
            if((temp.size() > 0 && temp.size() < res.size()) || res.size() == 0){
                res.clear();
                res.addAll(temp);
            }
            dir.remove(dir.size()-1);
        }
        if(j+1 < graph[0].length) {
            dir.add('R');
            ArrayList<Character> temp = dfs(graph,i,j+1,dir);
            if((temp.size() > 0 && temp.size() < res.size()) || res.size() == 0){
                res.clear();
                res.addAll(temp);
            }
            dir.remove(dir.size()-1);
        }
        if(j-1 >= 0) {
            dir.add('L');
            ArrayList<Character> temp = dfs(graph,i,j-1,dir);
            if((temp.size() > 0 && temp.size() < res.size()) || res.size() == 0){
                res.clear();
                res.addAll(temp);
            }
            dir.remove(dir.size()-1);
        }
        return res;
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
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                if(graph[i][j] == 'A') {
                    ArrayList<Character> res = dfs(graph,i,j,new ArrayList<>());
                    if(res.size() == 0){
                        out.println("NO");
                    } else {
                        out.println("YES");
                        out.println(res.size());
                        for(char k: res){
                            out.print(k);
                        }
                        out.println();
                    }
                }
            }
        }
        out.close();
        f.close();
    }
}
