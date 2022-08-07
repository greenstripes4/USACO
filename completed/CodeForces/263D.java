import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static ArrayList<Integer> res;
    private static int[] visited;
    private static void dfs(int u) {
        res.add(u);
        int min = adjacencyList.get(u).get(0);
        for(int v: adjacencyList.get(u)) {
            if(visited[v] == -1) {
                visited[v] = visited[u]+1;
                dfs(v);
                return;
            }
            if(visited[v] < visited[min]) {
                min = v;
            }
        }
        res.add(min);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            adjacencyList.get(a).add(b);
            adjacencyList.get(b).add(a);
        }
        res = new ArrayList<>();
        visited = new int[n];
        Arrays.fill(visited, -1);
        visited[0] = 0;
        dfs(0);
        ArrayList<Integer> v = new ArrayList<>();
        v.add(res.get(res.size()-1));
        for(int i = res.size()-2; i >= 0; i--) {
            if(res.get(i).equals(res.get(res.size()-1))) {
                break;
            }
            v.add(res.get(i));
        }
        out.println(v.size());
        out.print(v.get(0)+1);
        for(int i = 1; i < v.size(); i++) {
            out.print(" " + (v.get(i)+1));
        }
        out.println();
        f.close();
        out.close();
    }
}