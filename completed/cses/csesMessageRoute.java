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
        ArrayList<Integer>[] adjacencyList = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n+1];
        queue.offer(1);
        visited[1] = 1;
        int steps = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int temp = queue.poll();
                if(temp == n) {
                    break;
                }
                for(int j: adjacencyList[temp]) {
                    if(visited[j] == 0) {
                        queue.offer(j);
                        visited[j] = temp;
                    }
                }
            }
            if(visited[n] > 0) {
                break;
            }
            steps++;
        }
        if(visited[n] == 0) {
            out.println("IMPOSSIBLE");
        } else {
            ArrayList<Integer> path = new ArrayList<>();
            while(n > 1) {
                path.add(n);
                n = visited[n];
            }
            Collections.reverse(path);
            out.println(path.size()+1);
            out.print(1);
            for(int i: path) {
                out.print(" " + i);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}