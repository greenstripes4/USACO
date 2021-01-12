import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] adjacencyList = new ArrayList[n];
            for(int j = 0; j < n; j++) {
                adjacencyList[j] = new ArrayList<>();
            }
            for(int j = 0; j < m; j++) {
                st = new StringTokenizer(f.readLine());
                int v = Integer.parseInt(st.nextToken())-1;
                int u = Integer.parseInt(st.nextToken())-1;
                adjacencyList[v].add(u);
                adjacencyList[u].add(v);
            }
            LinkedList<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n];
            int[] steps = new int[n];
            Arrays.fill(steps, -1);
            queue.offer(0);
            visited[0] = true;
            steps[0] = 0;
            while(!queue.isEmpty()) {
                int temp = queue.poll();
                for(int j: adjacencyList[temp]) {
                    if(!visited[j]) {
                        queue.offer(j);
                        visited[j] = true;
                        steps[j] = steps[temp]+1;
                    }
                }
            }
            int even = 0;
            int odd = 0;
            for(int j: steps) {
                if(j%2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            int temp = even < odd ? 0 : 1;
            out.println(even < odd ? even : odd);
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if(steps[j]%2 == temp) {
                    sb.append(j+1);
                    sb.append(" ");
                }
            }
            sb.deleteCharAt(sb.length()-1);
            out.println(sb);
        }
        f.close();
        out.close();
    }
}
