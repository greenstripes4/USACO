import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("timeline.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("timeline.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] S = new int[N];
        for(int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<ArrayList<int[]>> adjacencyList = new ArrayList<>(N);
        for(int i = 0; i < N; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        int[] indegree = new int[N];
        for(int i = 0; i < C; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken());
            adjacencyList.get(a).add(new int[]{b, x});
            indegree[b]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int u = queue.poll();
            for(int[] v: adjacencyList.get(u)) {
                S[v[0]] = Math.max(S[v[0]], S[u]+v[1]);
                indegree[v[0]]--;
                if(indegree[v[0]] == 0) {
                    queue.offer(v[0]);
                }
            }
        }
        for(int i: S) {
            out.println(i);
        }
        f.close();
        out.close();
    }
}