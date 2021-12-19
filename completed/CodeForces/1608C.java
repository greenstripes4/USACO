import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static boolean[] visited;
    private static void dfs(int u) {
        visited[u] = true;
        for(int v: adjacencyList.get(u)) {
            if(!visited[v]) {
                dfs(v);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            Integer[] sortedByA = new Integer[n];
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                sortedByA[i] = i;
            }
            st = new StringTokenizer(f.readLine());
            Integer[] sortedByB = new Integer[n];
            int[] b = new int[n];
            for(int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
                sortedByB[i] = i;
            }
            Arrays.sort(sortedByA, new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return a[integer]-a[t1];
                }
            });
            Arrays.sort(sortedByB, new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return b[integer]-b[t1];
                }
            });
            adjacencyList = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                adjacencyList.add(new ArrayList<>());
            }
            for(int i = 0; i < n-1; i++) {
                adjacencyList.get(sortedByA[i]).add(sortedByA[i+1]);
                adjacencyList.get(sortedByB[i]).add(sortedByB[i+1]);
            }
            visited = new boolean[n];
            dfs(sortedByA[n-1]);
            for(int i = 0; i < n; i++) {
                out.print(visited[i] ? "1" : "0");
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
