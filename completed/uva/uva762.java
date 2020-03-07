/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<ArrayList<String>> allPaths = new ArrayList<>();
    public static boolean dfs(HashMap<String,HashSet<String>> connections, String source, String dest, ArrayList<String> path, HashSet<String> visited){
        if(source.equals(dest)){
            ArrayList<String> temp = new ArrayList<>();
            for(String i: path){
                temp.add(i);
            }
            allPaths.add(temp);
            return true;
        }
        boolean found = false;
        if(connections.containsKey(source)) {
            HashSet<String> neighbors = connections.get(source);
            for (String i : neighbors) {
                if(!visited.contains(i)){
                    path.add(i);
                    visited.add(i);
                    if (dfs(connections,i,dest,path,visited)) {
                        found = true;
                    }
                    visited.remove(i);
                    path.remove(path.size() - 1);
                }
            }
        }
        return found;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("loan.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null && !input.equals("")){
            int N = Integer.parseInt(input);
            HashMap<String,HashSet<String>> connections = new HashMap<>();
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if(connections.containsKey(a)){
                    connections.get(a).add(b);
                } else {
                    HashSet<String> temp = new HashSet<>();
                    temp.add(b);
                    connections.put(a,temp);
                }
                if(connections.containsKey(b)){
                    connections.get(b).add(a);
                } else {
                    HashSet<String> temp = new HashSet<>();
                    temp.add(a);
                    connections.put(b,temp);
                }
            }
            StringTokenizer st = new StringTokenizer(f.readLine());
            String source = st.nextToken();
            String dest = st.nextToken();
            ArrayList<String> curPath = new ArrayList<>();
            curPath.add(source);
            boolean isPath = dfs(connections,source,dest,curPath,new HashSet<>());
            if(!isPath){
                out.println("No route");
            } else {
                int size = Integer.MAX_VALUE;
                ArrayList<String> shortestPath = new ArrayList<>();
                for (ArrayList<String> path : allPaths) {
                    if (path.size() < size) {
                        size = path.size();
                        shortestPath = path;
                    }
                }
                for(int i = 0; i < size-1; i++){
                    out.println(shortestPath.get(i) + " " + shortestPath.get(i+1));
                }
            }
            out.println();
            f.readLine();
            allPaths.clear();
        }
        out.close();
        f.close();
    }
}
