import java.io.*;
import java.util.*;

public class Main{
    private static void dfs(HashMap<Character,ArrayList<Character>> roads, char start, char end, StringBuilder path, ArrayList<String> allPaths){
        if(start == end){
            allPaths.add(path.toString());
        }
        ArrayList<Character> possibleNextCities = roads.get(start);
        for(char i: possibleNextCities){
            if(path.indexOf(Character.toString(i)) < 0){
                path.append(i);
                dfs(roads,i,end,path,allPaths);
                path.delete(path.length()-1,path.length());
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCases = Integer.parseInt(f.readLine());
        for(int i = 0; i < testCases; i++){
            if(i > 0){
                out.println();
            }
            f.readLine();
            StringTokenizer st = new StringTokenizer(f.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            HashMap<Character,ArrayList<Character>> roads = new HashMap<>();
            for(int j = 0; j < m; j++){
                StringTokenizer connection = new StringTokenizer(f.readLine());
                char city1 = connection.nextToken().charAt(0);
                char city2 = connection.nextToken().charAt(0);
                ArrayList<Character> city1Roads = roads.getOrDefault(city1,new ArrayList<>());
                city1Roads.add(city2);
                ArrayList<Character> city2Roads = roads.getOrDefault(city2,new ArrayList<>());
                city2Roads.add(city1);
                roads.put(city1,city1Roads);
                roads.put(city2,city2Roads);
            }
            for(int j = 0; j < n; j++){
                StringTokenizer query = new StringTokenizer(f.readLine());
                char city1 = query.nextToken().charAt(0);
                char city2 = query.nextToken().charAt(0);
                ArrayList<String> allPaths = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                sb.append(city1);
                dfs(roads,city1,city2,sb,allPaths);
                String shortestPath = null;
                for(String k: allPaths){
                    if(shortestPath == null || k.length() < shortestPath.length()){
                        shortestPath = k;
                    }
                }
                out.println(shortestPath);
            }
        }
        f.close();
        out.close();
    }
}
