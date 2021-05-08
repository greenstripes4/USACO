import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;
    private static int root(int u) {
        while(u != parent[u]) {
            u = parent[u];
        }
        return u;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int N = f.nextInt();
            int Q = f.nextInt();
            if(N == 0 && Q == 0) {
                break;
            }
            ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>(N);
            parent = new int[N];
            for(int i = 0; i < N; i++) {
                adjacencyList.add(new ArrayList<>());
                parent[i] = i;
            }
            for(int i = 1; i < N; i++) {
                int p = f.nextInt()-1;
                adjacencyList.get(p).add(i);
            }
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0});
            while(!queue.isEmpty()) {
                int[] next = queue.poll();
                parent[next[0]] = next[1];
                for(int i: adjacencyList.get(next[0])) {
                    queue.offer(new int[]{i, next[0]});
                }
            }
            long ans = 0;
            for(int i = 0; i < Q; i++) {
                if(f.next().equals("M")) {
                    int v = f.nextInt()-1;
                    parent[v] = v;
                } else {
                    int v = f.nextInt()-1;
                    ans += root(v)+1;
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}