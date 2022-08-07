import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>(n+1);
            for(int i = 0; i <= n; i++) {
                adjacencyList.add(new ArrayList<>());
            }
            int[][] edges = new int[m][2];
            int[] indegree = new int[n+1];
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(f.readLine());
                int type = Integer.parseInt(st.nextToken());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                edges[i][0] = u;
                edges[i][1] = v;
                if(type == 1) {
                    adjacencyList.get(u).add(v);
                    indegree[v]++;
                }
            }
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 1; i <= n; i++) {
                if(indegree[i] == 0) {
                    queue.offer(i);
                }
            }
            int[] map = new int[n+1];
            int idx = 0;
            boolean flag = false;
            while(!queue.isEmpty() && !flag) {
                int u = queue.poll();
                map[u] = idx++;
                for(int v: adjacencyList.get(u)) {
                    indegree[v]--;
                    if(indegree[v] == 0) {
                        queue.offer(v);
                    } else if(indegree[v] < 0) {
                        flag = true;
                        break;
                    }
                }
            }
            if(idx < n || flag) {
                out.println("NO");
            } else {
                out.println("YES");
                for(int[] e: edges) {
                    if(map[e[1]] < map[e[0]]) {
                        int temp = e[0];
                        e[0] = e[1];
                        e[1] = temp;
                    }
                    out.println(e[0] + " " + e[1]);
                }
            }
        }
        f.close();
        out.close();
    }
}