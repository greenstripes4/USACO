import java.io.*;
import java.util.*;
//
public class Main {
    private static int n;
    private static ArrayList<ArrayList<int[]>> adjacencyList;
    private static boolean spfa(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        long[] distance = new long[n+1];
        Arrays.fill(distance, Long.MAX_VALUE);
        boolean[] enqueued = new boolean[n+1];
        int[] count = new int[n+1];
        queue.offer(start);
        distance[start] = 0;
        enqueued[start] = true;
        count[start]++;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            long dist = distance[node];
            enqueued[node] = false;
            for(int[] edge: adjacencyList.get(node)) {
                int next = edge[0];
                int weight = edge[1];
                if(dist+weight < distance[next]) {
                    distance[next] = dist+weight;
                    if(!enqueued[next]) {
                        if(count[next] == n-1) {
                            return true;
                        }
                        queue.offer(next);
                        enqueued[next] = true;
                        count[next]++;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int F = Integer.parseInt(f.readLine());
        while(F-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            n = Integer.parseInt(st.nextToken());
            int ML = Integer.parseInt(st.nextToken());
            int MD = Integer.parseInt(st.nextToken());
            adjacencyList = new ArrayList<ArrayList<int[]>>();
            for(int i = 0; i <= n; i++) {
                adjacencyList.add(new ArrayList<int[]>());
            }
            for(int i = 0; i < ML; i++) {
                st = new StringTokenizer(f.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int D = Integer.parseInt(st.nextToken());
                adjacencyList.get(A).add(new int[]{B, D});
                adjacencyList.get(B).add(new int[]{A, D});
            }
            for(int i = 0; i < MD; i++) {
                st = new StringTokenizer(f.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int D = Integer.parseInt(st.nextToken());
                adjacencyList.get(A).add(new int[]{B, -D});
            }
            out.println(spfa(1) ? "YES" : "NO");
        }
        f.close();
        out.close();
    }
}
