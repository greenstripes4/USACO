import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] T = new int[n];
            for(int i = 0; i < n; i++) {
                T[i] = Integer.parseInt(st.nextToken());
            }
            ArrayList<ArrayList<int[]>> adjacencyList = new ArrayList<>(100);
            for(int i = 0; i < 100; i++) {
                adjacencyList.add(new ArrayList<>());
            }
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(f.readLine());
                ArrayList<Integer> temp = new ArrayList<>();
                while(st.hasMoreTokens()) {
                    temp.add(Integer.parseInt(st.nextToken()));
                }
                for(int j: temp) {
                    for(int l: temp) {
                        if(j != l) {
                            adjacencyList.get(j).add(new int[]{l, i});
                        }
                    }
                }
            }
            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[1]-t1[1];
                }
            });
            queue.offer(new int[]{0, 0, -1});
            boolean[] processed = new boolean[100];
            int[] distance = new int[100];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[0] = 0;
            while(!queue.isEmpty()) {
                int[] cur = queue.poll();
                if(processed[cur[0]]) {
                    continue;
                }
                processed[cur[0]] = true;
                for(int[] edge: adjacencyList.get(cur[0])) {
                    int[] next = new int[]{edge[0], cur[1]+T[edge[1]]*Math.abs(edge[0]-cur[0]), edge[1]};
                    if(cur[2] >= 0 && next[2] != cur[2]) {
                        next[1] += 60;
                    }
                    if(next[1] < distance[next[0]]) {
                        queue.offer(next);
                        distance[next[0]] = next[1];
                    }
                }
            }
            out.println(distance[k] == Integer.MAX_VALUE ? "IMPOSSIBLE" : distance[k]);
        }
        f.close();
        out.close();
    }
}