import java.io.*;
import java.util.*;

public class Main {
    private static HashMap<Integer, ArrayList<Integer>> adjacencyList;
    private static HashSet<Integer> visited;
    private static boolean dfs(int u) {
        visited.add(u);
        if(!adjacencyList.containsKey(u)) {
            return false;
        }
        for(int v: adjacencyList.get(u)) {
            if(visited.contains(v)) {
                return true;
            }
            dfs(v);
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = 1;
        while(true) {
            int a = f.nextInt();
            int b = f.nextInt();
            if(a < 0 && b < 0) {
                break;
            }
            if(a == 0 && b == 0) {
                out.println("Case " + t++ + " is a tree.");
            } else {
                HashSet<Integer> degree = new HashSet<>();
                HashSet<Integer> total = new HashSet<>();
                adjacencyList = new HashMap<>();
                degree.add(b);
                total.add(a);
                total.add(b);
                adjacencyList.put(a, new ArrayList<>());
                adjacencyList.get(a).add(b);
                while(true) {
                    a = f.nextInt();
                    b = f.nextInt();
                    if(a == 0 && b == 0) {
                        break;
                    }
                    degree.add(b);
                    total.add(a);
                    total.add(b);
                    adjacencyList.putIfAbsent(a, new ArrayList<>());
                    adjacencyList.get(a).add(b);
                }
                int root = 0;
                boolean flag = false;
                for(int i: total) {
                    if(!degree.contains(i)) {
                        if(root > 0) {
                            flag = true;
                            break;
                        }
                        root = i;
                    }
                }
                if(flag || root == 0) {
                    out.println("Case " + t++ + " is not a tree.");
                } else {
                    visited = new HashSet<>();
                    flag = dfs(root);
                    if(flag || visited.size() != total.size()) {
                        out.println("Case " + t++ + " is not a tree.");
                    } else {
                        out.println("Case " + t++ + " is a tree.");
                    }
                }
            }
        }
        f.close();
        out.close();
    }
}
