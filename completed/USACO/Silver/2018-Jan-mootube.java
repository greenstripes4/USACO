import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("mootube.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] adjacencyList = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(f.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            adjacencyList[p].add(new int[]{q,r});
            adjacencyList[q].add(new int[]{p,r});
        }
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(f.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            Queue<Integer> queue = new LinkedList<>();
            boolean[] seen = new boolean[N+1];
            queue.add(v);
            seen[v] = true;
            int recommended = 0;
            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int j = 0; j < size; j++) {
                    int temp = queue.poll();
                    for(int[] l: adjacencyList[temp]) {
                        if(!seen[l[0]] && l[1] >= k) {
                            queue.add(l[0]);
                            seen[l[0]] = true;
                            recommended++;
                        }
                    }
                }
            }
            out.println(recommended);
        }
        f.close();
        out.close();
    }
}
