import java.io.*;
import java.util.*;

public class Main{
    private static HashSet<Integer> seen;
    private static void dfs(HashMap<Integer,ArrayList<Integer>> edges, int root){
        for(int i: edges.get(root)){
            if(!seen.contains(i)) {
                seen.add(i);
                dfs(edges, i);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true){
            int n = f.nextInt();
            if(n == 0){
                break;
            }
            HashMap<Integer,ArrayList<Integer>> edges = new HashMap<>();
            for(int i = 1; i <= n; i++){
                edges.put(i,new ArrayList<>());
            }
            while(true){
                int i = f.nextInt();
                if(i == 0){
                    break;
                }
                ArrayList<Integer> temp = edges.get(i);
                while(true){
                    int j = f.nextInt();
                    if(j == 0){
                        break;
                    }
                    temp.add(j);
                }
            }
            int queries = f.nextInt();
            for(int i = 0; i < queries; i++){
                int root = f.nextInt();
                seen = new HashSet<>();
                dfs(edges,root);
                out.print(n-seen.size());
                for(int j = 1; j <= n; j++){
                    if(!seen.contains(j)){
                        out.print(" " + j);
                    }
                }
                out.println();
            }
        }
        f.close();
        out.close();
    }
}
