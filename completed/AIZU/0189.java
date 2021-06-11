import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<int[]>> adjacencyList;
    private static int dijkstra(int start) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[1]-t1[1];
            }
        });
        boolean[] processed = new boolean[10];
        int[] distance = new int[10];
        Arrays.fill(distance, Integer.MAX_VALUE);
        queue.offer(new int[]{start, 0});
        distance[start] = 0;
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            if(processed[temp[0]]) {
                continue;
            }
            processed[temp[0]] = true;
            for(int[] next: adjacencyList.get(temp[0])) {
                if(temp[1]+next[1] < distance[next[0]]) {
                    queue.offer(new int[]{next[0], temp[1]+next[1]});
                    distance[next[0]] = temp[1]+next[1];
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < 10; i++) {
            if(distance[i] != Integer.MAX_VALUE) {
                sum += distance[i];
            }
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int n = Integer.parseInt(f.readLine());
            if(n == 0) {
                break;
            }
            adjacencyList = new ArrayList<>();
            for(int i = 0; i < 10; i++) {
                adjacencyList.add(new ArrayList<>());
            }
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                adjacencyList.get(a).add(new int[]{b, c});
                adjacencyList.get(b).add(new int[]{a, c});
            }
            int ans = 10;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < 10; i++) {
                if(adjacencyList.get(i).size() > 0) {
                    int temp = dijkstra(i);
                    if(temp < min) {
                        ans = i;
                        min = temp;
                    }
                }
            }
            out.println(ans + " " + min);
        }
        f.close();
        out.close();
    }
}