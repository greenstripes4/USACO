import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[][] edges;
    private static boolean isValid(int k) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for(int i = 0; i < k; i++) {
            adjacencyList.get(edges[i][0]).add(edges[i][1]);
            degree[edges[i][1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(degree[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            if(queue.size() > 1) {
                return false;
            }
            int u = queue.poll();
            for(int v: adjacencyList.get(u)) {
                degree[v]--;
                if(degree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        edges = new int[m][2];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken())-1;
            edges[i][1] = Integer.parseInt(st.nextToken())-1;
        }
        int low = 0;
        int high = m;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(isValid(mid)) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
