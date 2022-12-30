import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] degree;
    private static ArrayList<Integer> arr;
    private static boolean[] visited;
    private static void dfs(int u) {
        if(visited[u]) {
            return;
        }
        arr.add(u);
        visited[u] = true;
        for(int v: adjacencyList.get(u)) {
            dfs(v);
        }
    }
    private static long process(ArrayList<Integer> component) {
        TreeMap<Integer, HashSet<Integer>> map = new TreeMap<>();
        for(int u: component) {
            map.putIfAbsent(degree[u], new HashSet<>());
            map.get(degree[u]).add(u);
        }
        HashSet<Integer> removed = new HashSet<>();
        long ans = (long) map.firstKey()*component.size();
        while(true) {
            HashSet<Integer> set = map.remove(map.firstKey());
            removed.addAll(set);
            for(int u: set) {
                for(int v: adjacencyList.get(u)) {
                    if(!removed.contains(v)) {
                        map.get(degree[v]).remove(v);
                        if(map.get(degree[v]).isEmpty()) {
                            map.remove(degree[v]);
                        }
                        degree[v]--;
                        map.putIfAbsent(degree[v], new HashSet<>());
                        map.get(degree[v]).add(v);
                    }
                }
            }
            if(map.isEmpty()) {
                break;
            }
            ans = Math.max(ans, (long) map.firstKey()*(component.size()-removed.size()));
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList<>(N);
        for(int i = 0; i < N; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        degree = new int[N];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                arr = new ArrayList<>();
                dfs(i);
                components.add(arr);
            }
        }
        long max = 0;
        for(ArrayList<Integer> i: components) {
            max = Math.max(max, process(i));
        }
        out.println(max);
        f.close();
        out.close();
    }
}
