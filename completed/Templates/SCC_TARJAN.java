import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static boolean[] pushed;
    private static int[] in;
    private static int[] low;
    private static int time;
    private static Stack<Integer> stack;
    private static int count;
    private static void dfs(int u, int p) {
        low[u] = in[u] = time++;
        stack.push(u);
        pushed[u] = true;
        for(int v: adjacencyList.get(u)) {
            if(v != p) {
                if(in[v] == -1) {
                    dfs(v, u);
                    low[u] = Math.min(low[u], low[v]);
                } else if(pushed[v]) {
                    low[u] = Math.min(low[u], in[v]);
                }
            }
        }
        if(low[u] == in[u]) {
            count++;
            while(stack.peek() != u) {
                pushed[stack.pop()] = false;
            }
            pushed[stack.pop()] = false;
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
