import java.io.*;
import java.util.*;

public class Main{
    public static int dfs(int[][] graph, boolean[][] seen, int root, int parent){
        int length = 0;
        for(int i: graph[root]){
            if(i >= 0 && !seen[Math.min(root,i)][Math.max(root,i)]){
                seen[Math.min(root,i)][Math.max(root,i)] = true;
                length = Math.max(length,dfs(graph,seen,i,root)+1);
                seen[Math.min(root,i)][Math.max(root,i)] = false;
            }
        }
        return length;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true){
            int n = f.nextInt();
            int m = f.nextInt();
            if(n == 0 && m == 0){
                break;
            }
            int[][] graph = new int[n][3];
            for(int[] i: graph){
                Arrays.fill(i,-1);
            }
            for(int i = 0; i < m; i++){
                int a = f.nextInt();
                int b = f.nextInt();
                for(int j = 0; j < 3; j++){
                    if(graph[a][j] == -1){
                        graph[a][j] = b;
                        break;
                    }
                }
                for(int j = 0; j < 3; j++){
                    if(graph[b][j] == -1){
                        graph[b][j] = a;
                        break;
                    }
                }
            }
            int maxLength = 0;
            for(int i = 0; i < n; i++){
                maxLength = Math.max(maxLength,dfs(graph,new boolean[n][n],i,-1));
            }
            out.println(maxLength);
        }
        f.close();
        out.close();
    }
}
