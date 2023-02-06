import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int M;
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] match;
    private static boolean[] visited;
    private static boolean augment(int u) {
        if(visited[u]) {
            return false;
        }
        visited[u] = true;
        for(int v: adjacencyList.get(u)) {
            if(match[v] == -1 || augment(match[v])) {
                match[v] = u;
                return true;
            }
        }
        return false;
    }
    private static void kuhn() {
        match = new int[M];
        Arrays.fill(match, -1);
        for(int i = 0; i < N; i++) {
            visited = new boolean[M];
            augment(i);
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        f.close();
        out.close();
    }
}
