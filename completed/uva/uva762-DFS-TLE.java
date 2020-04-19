import java.io.*;
import java.util.*;

public class Main{
    private static void dfs(HashMap<String,HashSet<String>> connections, String source, String destination, StringBuilder path, ArrayList<String> allPaths){
        if(source.equals(destination)){
            String temp = path.toString();
            temp = temp.substring(0,temp.length()-1);
            allPaths.add(temp);
            return;
        }
        HashSet<String> nextCities = connections.get(source);
        for(String i: nextCities){
            if(path.indexOf(i) < 0){
                path.append(source);
                path.append(" ");
                path.append(i);
                path.append("\n");
                dfs(connections,i,destination,path,allPaths);
                path.delete(path.length()-6,path.length());
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        int testCase = 0;
        while((input = f.readLine()) != null){
            if(testCase > 0){
                out.println();
            }
            int links = Integer.parseInt(input);
            HashMap<String,HashSet<String>> connections = new HashMap<>();
            for(int i = 0; i < links; i++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                String city1 = st.nextToken();
                String city2 = st.nextToken();
                HashSet<String> city1Connections = connections.getOrDefault(city1,new HashSet<>());
                HashSet<String> city2Connections = connections.getOrDefault(city2,new HashSet<>());
                city1Connections.add(city2);
                city2Connections.add(city1);
                connections.put(city1,city1Connections);
                connections.put(city2,city2Connections);
            }
            StringTokenizer st = new StringTokenizer(f.readLine());
            String source = st.nextToken();
            String destination = st.nextToken();
            if(!connections.containsKey(source) || !connections.containsKey(destination)){
                out.println("No route");
            } else {
                ArrayList<String> allPaths = new ArrayList<>();
                dfs(connections, source, destination, new StringBuilder(), allPaths);
                if (allPaths.size() == 0) {
                    out.println("No route");
                } else {
                    String shortestPath = "";
                    for (String i : allPaths) {
                        if (shortestPath.equals("") || i.length() < shortestPath.length()) {
                            shortestPath = i;
                        }
                    }
                    out.println(shortestPath);
                }
            }
            testCase++;
            f.readLine();
        }
        f.close();
        out.close();
    }
}
