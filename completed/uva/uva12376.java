import java.io.*;
import java.util.*;

public class Main{
    private static int maximumLearningUnits;
    private static int endNode;
    private static void dfs(int[] learningUnits, ArrayList<Integer>[] edges, int source) {
        if(edges[source].size() == 0) {
            endNode = source;
            return;
        }
        int nextNode = -1;
        for(int i: edges[source]) {
            if(nextNode == -1 || learningUnits[i] > learningUnits[nextNode]) {
                nextNode = i;
            }
        }
        maximumLearningUnits += learningUnits[nextNode];
        dfs(learningUnits,edges,nextNode);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = f.nextInt();
        for(int t = 0; t < T; t++) {
            int n = f.nextInt();
            int m = f.nextInt();
            int[] learningUnits = new int[n];
            ArrayList<Integer>[] edges = new ArrayList[n];
            for(int i = 0; i < n; i++) {
                learningUnits[i] = f.nextInt();
                edges[i] = new ArrayList<>();
            }
            for(int i = 0; i < m; i++) {
                int u = f.nextInt();
                int v = f.nextInt();
                edges[u].add(v);
            }
            maximumLearningUnits = 0;
            endNode = -1;
            dfs(learningUnits,edges,0);
            out.println("Case " + (t+1) + ": " + maximumLearningUnits + " " + endNode);
        }
        f.close();
        out.close();
    }
}
