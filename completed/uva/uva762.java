import java.io.*;
import java.util.*;

public class Main{
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
            boolean found = false;
            if(connections.containsKey(source) && connections.containsKey(destination)) {
                Queue<String> queue = new LinkedList<>();
                queue.add(source);
                HashMap<String, String> parentage = new HashMap<>();
                while (!queue.isEmpty()) {
                    String next = queue.poll();
                    if (next.equals(destination)) {
                        found = true;
                        break;
                    }
                    HashSet<String> neighbors = connections.get(next);
                    for (String i : neighbors) {
                        if (!parentage.containsKey(i)) {
                            parentage.put(i, next);
                            queue.add(i);
                        }
                    }
                }
                if(!found){
                    out.println("No route");
                } else {
                    String parent = destination;
                    ArrayList<String> path = new ArrayList<>();
                    while(!parent.equals(source)){
                        path.add(parentage.get(parent)+" "+parent);
                        parent = parentage.get(parent);
                    }
                    Collections.reverse(path);
                    for(String i: path){
                        out.println(i);
                    }
                }
            } else {
                out.println("No route");
            }
            testCase++;
            f.readLine();
        }
        f.close();
        out.close();
    }
}
