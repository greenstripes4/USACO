import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = f.nextInt();
        while(T-- > 0) {
            int n = f.nextInt();
            int m = f.nextInt();
            ArrayList<ArrayList<int[]>> adjacencyList = new ArrayList<>();
            for(int i = 0; i <= n; i++) {
                adjacencyList.add(new ArrayList<>());
            }
            for(int i = 0; i < n-1; i++) {
                int a = f.nextInt();
                int b = f.nextInt();
                int w = f.nextInt();
                adjacencyList.get(a).add(new int[]{b, w});
                adjacencyList.get(b).add(new int[]{a, w});
            }
            for(int i = 0; i < m; i++) {
                int a = f.nextInt();
                int b = f.nextInt();
                Queue<int[]> queue = new LinkedList<>();
                boolean[] visited = new boolean[n+1];
                queue.offer(new int[]{a, 0});
                visited[a] = true;
                while(!queue.isEmpty()) {
                    int[] next = queue.poll();
                    if(next[0] == b) {
                        out.println(next[1]);
                        break;
                    }
                    for(int[] j: adjacencyList.get(next[0])) {
                        if(!visited[j[0]]) {
                            queue.offer(new int[]{j[0], next[1]+j[1]});
                            visited[j[0]] = true;
                        }
                    }
                }
            }
        }
        f.close();
        out.close();
    }
}