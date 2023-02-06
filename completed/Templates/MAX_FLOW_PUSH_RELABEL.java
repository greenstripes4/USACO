import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] capacity;
    private static int[][] flow;
    private static int[] height;
    private static int[] excess;
    private static int source;
    private static int sink;
    private static void push(int u, int v) {
        int amount = Math.min(excess[u], capacity[u][v]-flow[u][v]);
        flow[u][v] += amount;
        flow[v][u] -= amount;
        excess[u] -= amount;
        excess[v] += amount;
    }
    private static void relabel(int u) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            if(capacity[u][i] > flow[u][i]) {
                min = Math.min(min, height[i]);
            }
        }
        height[u] = min+1;
    }
    private static ArrayList<Integer> generateMaxHeightVertices() {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            if(i != source && i != sink && excess[i] > 0) {
                if(!arr.isEmpty() && height[i] > height[arr.get(0)]) {
                    arr.clear();
                }
                if(arr.isEmpty() || height[i] == height[arr.get(0)]) {
                    arr.add(i);
                }
            }
        }
        return arr;
    }
    private static int maxFlow() {
        height[source] = N;
        excess[source] = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            if(i != source) {
                push(source, i);
            }
        }
        ArrayList<Integer> arr;
        while(!(arr = generateMaxHeightVertices()).isEmpty()) {
            for(int i: arr) {
                boolean pushed = false;
                for(int j = 0; j < N && excess[i] > 0; j++) {
                    if(capacity[i][j] > flow[i][j] && height[i] > height[j]) {
                        push(i, j);
                        pushed = true;
                    }
                }
                if(!pushed) {
                    relabel(i);
                    break;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < N; i++) {
            ans += flow[i][sink];
        }
        return ans;
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
