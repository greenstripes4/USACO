import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] rank = new int[n+1];
            for(int i = 0; i < n; i++) {
                rank[Integer.parseInt(st.nextToken())] = i;
            }
            HashMap<Integer, HashSet<Integer>> reverse = new HashMap<>();
            int m = Integer.parseInt(f.readLine());
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(f.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                reverse.putIfAbsent(a, new HashSet<>());
                reverse.putIfAbsent(b, new HashSet<>());
                reverse.get(a).add(b);
                reverse.get(b).add(a);
            }
            ArrayList<Integer>[] adjacencyList = new ArrayList[n+1];
            for(int i = 1; i <= n; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
            for(int i = 1; i <= n; i++) {
                for(int j = i+1; j <= n; j++) {
                    int order = Integer.compare(rank[i], rank[j]);
                    if(reverse.containsKey(i) && reverse.get(i).contains(j)) {
                        order = -order;
                    }
                    if(order < 0) {
                        adjacencyList[i].add(j);
                    } else {
                        adjacencyList[j].add(i);
                    }
                }
            }
            int[] indegree = new int[n+1];
            for(int i = 1; i <= n; i++) {
                for(int j: adjacencyList[i]) {
                    indegree[j]++;
                }
            }
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 1; i <= n; i++) {
                if(indegree[i] == 0) {
                    queue.offer(i);
                }
            }
            int[] res = new int[n];
            int k = 0;
            boolean flag = false;
            while(!flag && !queue.isEmpty()) {
                int cur = queue.poll();
                res[k++] = cur;
                for(int next: adjacencyList[cur]) {
                    indegree[next]--;
                    if(indegree[next] < 0) {
                        flag = true;
                        break;
                    }
                    if(indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
            if(k < n) {
                out.println("IMPOSSIBLE");
            } else {
                out.print(res[0]);
                for(int i = 1; i < n; i++) {
                    out.print(" " + res[i]);
                }
                out.println();
            }
        }
        f.close();
        out.close();
    }
}
