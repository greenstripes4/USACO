import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        LinkedList<Integer>[] types = new LinkedList[k];
        for(int i = 0; i < k; i++) {
            types[i] = new LinkedList<>();
        }
        int[][] closest = new int[n][k];
        for(int[] i: closest) {
            Arrays.fill(i, -1);
        }
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken())-1;
            types[a[i]].add(i);
            closest[i][a[i]] = 0;
        }
        ArrayList<Integer>[] adjacencyList = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }
        for(int i = 0; i < k; i++) {
            int steps = 1;
            while(!types[i].isEmpty()) {
                int size = types[i].size();
                while(size-- > 0) {
                    int cur = types[i].poll();
                    for(int next: adjacencyList[cur]) {
                        if(closest[next][i] < 0) {
                            types[i].offer(next);
                            closest[next][i] = steps;
                        }
                    }
                }
                steps++;
            }
        }
        for(int i = 0; i < n; i++) {
            Arrays.sort(closest[i]);
            int sum = 0;
            for(int j = 0; j < s; j++) {
                sum += closest[i][j];
            }
            out.print(sum + " ");
        }
        out.println();
        f.close();
        out.close();
    }
}