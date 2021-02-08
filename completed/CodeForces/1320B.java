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
        ArrayList<Integer>[] uninverted = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
            uninverted[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjacencyList[v].add(u);
            uninverted[u].add(v);
        }
        int k = Integer.parseInt(f.readLine());
        st = new StringTokenizer(f.readLine());
        int[] p = new int[k];
        for(int i = 0; i < k; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        int[] distances = new int[n+1];
        Arrays.fill(distances, n);
        distances[p[k-1]] = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(p[k-1]);
        while(!queue.isEmpty()) {
            int next = queue.poll();
            for(int i: adjacencyList[next]) {
                if(distances[i] == n) {
                    distances[i] = distances[next]+1;
                    queue.add(i);
                }
            }
        }
        int min = 0;
        int max = 0;
        for(int i = 1; i < k; i++) {
            if(distances[p[i]] >= distances[p[i-1]]) {
                min++;
                max++;
            } else {
                for(int j: uninverted[p[i-1]]) {
                    if(distances[j] == distances[p[i-1]]-1 && j != p[i]) {
                        max++;
                        break;
                    }
                }
            }
        }
        out.println(min + " " + max);
        f.close();
        out.close();
    }
}
