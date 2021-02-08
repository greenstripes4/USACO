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
        ArrayList<int[]>[] adjacencyList = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            adjacencyList[a].add(new int[]{b, c});
        }
        PriorityQueue<long[]> queue = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] longs, long[] t1) {
                return Long.compare(longs[1], t1[1]);
            }
        });
        boolean[] processed = new boolean[n];
        long[] distances = new long[n];
        Arrays.fill(distances, Long.MAX_VALUE);
        queue.offer(new long[]{0, 0});
        distances[0] = 0;
        while(!queue.isEmpty()) {
            int node = (int) queue.poll()[0];
            if(processed[node]) {
                continue;
            }
            processed[node] = true;
            for(int[] next: adjacencyList[node]) {
                if(distances[node]+next[1] < distances[next[0]]) {
                    distances[next[0]] = distances[node]+next[1];
                    queue.offer(new long[]{next[0], distances[next[0]]});
                }
            }
        }
        out.print(distances[0]);
        for(int i = 1; i < n; i++) {
            out.print(" " + distances[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}