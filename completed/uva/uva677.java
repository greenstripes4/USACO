import java.io.*;
import java.util.*;

public class Main{
    private static boolean dfs(int n, int length, int[][] adjacencyMatrix, int root, String path, HashSet<Integer> seen, PrintWriter out){
        if(length == n){
            out.println(path.substring(0,path.length()-1)+")");
            return true;
        }
        boolean found = false;
        for(int i = 0; i < adjacencyMatrix[root].length; i++){
            if(adjacencyMatrix[root][i] == 1 && !seen.contains(i)){
                seen.add(i);
                if(dfs(n,length+1,adjacencyMatrix,i,path+(i+1)+",",seen,out)){
                    found = true;
                }
                seen.remove(i);
            }
        }
        return found;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCase = 1;
        while(f.hasNext()){
            if(testCase > 1){
                out.println();
            }
            int m = f.nextInt();
            int n = f.nextInt();
            int[][] adjacencyMatrix = new int[m][m];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < m; j++){
                    adjacencyMatrix[i][j] = f.nextInt();
                }
            }
            HashSet<Integer> seen = new HashSet<>();
            seen.add(0);
            if(!dfs(n,0,adjacencyMatrix,0,"(1,",seen,out)){
                out.println("no walk of length " + n);
            }
            testCase++;
            if(f.hasNext()){
                f.nextInt();
            }
        }
        f.close();
        out.close();
    }
}
