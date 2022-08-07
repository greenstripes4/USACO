import java.io.*;
import java.util.*;

public class Main {
    private static int distance(int[] a, int[] b) {
        return b[0]-a[0]+b[1]-a[1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("boards.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("boards.in")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        ArrayList<int[]> arr = new ArrayList<>();
        HashMap<String, Integer> nodes = new HashMap<>();
        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();
        HashMap<Integer, Integer> edges = new HashMap<>();
        arr.add(new int[]{0, 0});
        nodes.put("0 0", 0);
        map.put(0, new TreeMap<>());
        map.get(0).put(0, new ArrayList<>());
        map.get(0).get(0).add(0);
        int idx = 1;
        for(int i = 0; i < P; i++) {
            st = new StringTokenizer(f.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            arr.add(new int[]{x1, y1});
            nodes.put(x1 + " " + y1, idx);
            map.putIfAbsent(x1, new TreeMap<>());
            map.get(x1).putIfAbsent(y1, new ArrayList<>());
            map.get(x1).get(y1).add(idx);
            idx++;
            arr.add(new int[]{x2, y2});
            nodes.put(x2 + " " + y2, idx);
            idx++;
            edges.put(nodes.get(x1 + " " + y1), nodes.get(x2 + " " + y2));
        }
        arr.add(new int[]{N, N});
        nodes.put(N + " " + N, idx);
        map.putIfAbsent(N, new TreeMap<>());
        map.get(N).putIfAbsent(N, new ArrayList<>());
        map.get(N).get(N).add(idx);
        edges.put(idx, idx);
        idx++;
        PriorityQueue<long[]> queue = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] longs, long[] t1) {
                return Long.compare(longs[1], t1[1]);
            }
        });
        boolean[] processed = new boolean[idx];
        long[] distance = new long[idx];
        Arrays.fill(distance, Long.MAX_VALUE);
        queue.offer(new long[]{0, 0});
        distance[0] = 0;
        while(!queue.isEmpty()) {
            long[] temp = queue.poll();
            int node = (int) temp[0];
            long dist = temp[1];
            if(processed[node]) {
                continue;
            }
            processed[node] = true;
            Integer nextX = map.ceilingKey(arr.get(node)[0]);
            while(nextX != null) {
                TreeMap<Integer, ArrayList<Integer>> temp2 = map.get(nextX);
                Integer nextY = temp2.ceilingKey(arr.get(node)[1]);
                while(nextY != null) {
                    for(int next: temp2.get(nextY)) {
                        if(next != node) {
                            int weight = distance(arr.get(node), arr.get(next));
                            if(dist+weight < distance[edges.get(next)]) {
                                queue.offer(new long[]{edges.get(next), dist+weight});
                                distance[edges.get(next)] = dist+weight;
                            }
                        }
                    }
                    nextY = temp2.higherKey(nextY);
                }
                nextX = map.higherKey(nextX);
            }
        }
        out.println(distance[idx-1]);
        f.close();
        out.close();
    }
}