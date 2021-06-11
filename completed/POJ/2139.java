import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] visited = new int[adjacencyList.size()];
        Arrays.fill(visited, -1);
        queue.offer(start);
        visited[start] = 0;
        int steps = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int temp = queue.poll();
                for(int i: adjacencyList.get(temp)) {
                    if(visited[i] < 0) {
                        queue.offer(i);
                        visited[i] = steps;
                    }
                }
            }
            steps++;
        }
        int sum = 0;
        for(int i = 1; i < adjacencyList.size(); i++) {
            sum += visited[i];
        }
        return sum*100/(adjacencyList.size()-2);
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= N; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            int Mi = Integer.parseInt(st.nextToken());
            int[] arr = new int[Mi];
            for(int j = 0; j < Mi; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                for(int k = 0; k < j; k++) {
                    adjacencyList.get(arr[j]).add(arr[k]);
                    adjacencyList.get(arr[k]).add(arr[j]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++) {
            int temp = bfs(i);
            min = Math.min(min, temp);
        }
        out.println(min);
        f.close();
        out.close();
    }
}