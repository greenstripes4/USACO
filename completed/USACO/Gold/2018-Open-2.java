import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static ArrayList<ArrayList<int[]>> edges;
    private static int[] topologicalSort(int k) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>(N+1);
        for(int i = 0; i < N+1; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        int[] degree = new int[N+1];
        for(int i = 0; i < k; i++) {
            for(int[] j: edges.get(i)) {
                adjacencyList.get(j[0]).add(j[1]);
                degree[j[1]]++;
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 1; i <= N; i++) {
            if(degree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[N];
        int idx = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            res[idx++] = cur;
            for(int next: adjacencyList.get(cur)) {
                degree[next]--;
                if(degree[next] < 0) {
                    return null;
                }
                if(degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return idx == N ? res : null;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milkorder.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkorder.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>(M);
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            int[] m = new int[Integer.parseInt(st.nextToken())];
            for(int j = 0; j < m.length; j++) {
                m[j] = Integer.parseInt(st.nextToken());
            }
            edges.add(new ArrayList<>());
            for(int j = 1; j < m.length; j++) {
                edges.get(i).add(new int[]{m[j-1], m[j]});
            }
        }
        int low = 0;
        int high = M;
        int[] ans = new int[N];
        while(low <= high) {
            int mid = (low+high)/2;
            int[] res = topologicalSort(mid);
            if(res != null) {
                low = mid+1;
                ans = res;
            } else {
                high = mid-1;
            }
        }
        out.print(ans[0]);
        for(int i = 1; i < N; i++) {
            out.print(" " + ans[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}
