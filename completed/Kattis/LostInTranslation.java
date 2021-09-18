import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        map.put("English", 0);
        for(int i = 1; i <= n; i++) {
            map.put(st.nextToken(), i);
        }
        ArrayList<ArrayList<int[]>> adjacencyList = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int u = map.get(st.nextToken());
            int v = map.get(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            adjacencyList.get(u).add(new int[]{v, d});
            adjacencyList.get(v).add(new int[]{u, d});
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        queue.offer(0);
        cost[0] = 0;
        while(!queue.isEmpty()) {
            int[] temp = cost.clone();
            int size = queue.size();
            while(size-- > 0) {
                int u = queue.poll();
                for(int[] v: adjacencyList.get(u)) {
                    if(cost[v[0]] == Integer.MAX_VALUE && v[1] < temp[v[0]]) {
                        temp[v[0]] = v[1];
                    }
                }
            }
            for(int i = 0; i <= n; i++) {
                if(temp[i] != cost[i]) {
                    queue.offer(i);
                }
            }
            cost = temp;
        }
        long sum = 0;
        boolean flag = false;
        for(int i: cost) {
            if(i == Integer.MAX_VALUE) {
                flag = true;
                break;
            }
            sum += i;
        }
        out.println(flag ? "Impossible" : sum);
        f.close();
        out.close();
    }
}