import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static int fillP(int root, int[] p, ArrayList<Integer>[] adjacencyList, boolean[] visited) {
        visited[root] = true;
        for(int i: adjacencyList[root]) {
            if(!visited[i]) {
                p[root] += fillP(i, p, adjacencyList, visited);
            }
        }
        return p[root];
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] p = new int[n];
            for(int j = 0; j < n; j++) {
                p[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(f.readLine());
            int[] h = new int[n];
            for(int j = 0; j < n; j++) {
                h[j] = Integer.parseInt(st.nextToken());
            }
            ArrayList<Integer>[] adjacencyList = new ArrayList[n];
            for(int j = 0; j < n; j++) {
                adjacencyList[j] = new ArrayList<>();
            }
            for(int j = 0; j < n-1; j++) {
                st = new StringTokenizer(f.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                adjacencyList[x].add(y);
                adjacencyList[y].add(x);
            }
            fillP(0, p, adjacencyList, new boolean[n]);
            int[] g = new int[n];
            boolean valid = true;
            for(int j = 0; j < n; j++) {
                g[j] = (p[j]+h[j])/2;
                if((p[j]+h[j])%2 != 0 || g[j] < 0 || g[j] > p[j]) {
                    valid = false;
                    break;
                }
            }
            if(!valid) {
                out.println("NO");
                continue;
            }
            LinkedList<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n];
            queue.push(0);
            visited[0] = true;
            while(!queue.isEmpty() && valid) {
                int temp = queue.poll();
                int sum = 0;
                for(int j: adjacencyList[temp]) {
                    if(!visited[j]) {
                        queue.offer(j);
                        visited[j] = true;
                        sum += g[j];
                        if(sum > g[temp]) {
                            valid = false;
                            break;
                        }
                    }
                }
            }
            out.println(valid ? "YES" : "NO");
        }
        f.close();
        out.close();
    }
}
