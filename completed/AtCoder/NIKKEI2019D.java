import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] p;
    private static int[] d;
    private static void dfs(int u) {
        for(int v: adjacencyList.get(u)) {
            d[v]--;
        }
        for(int v: adjacencyList.get(u)) {
            if(d[v] == 0 && p[v] == -1) {
                p[v] = u;
                dfs(v);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList<>(N);
        for(int i = 0; i < N; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        p = new int[N];
        Arrays.fill(p, -1);
        d = new int[N];
        for(int i = 0; i < N+M-1; i++) {
            st = new StringTokenizer(f.readLine());
            int A = Integer.parseInt(st.nextToken())-1;
            int B = Integer.parseInt(st.nextToken())-1;
            adjacencyList.get(A).add(B);
            d[B]++;
        }
        for(int i = 0; i < N; i++) {
            if(d[i] == 0) {
                dfs(i);
                break;
            }
        }
        for(int i: p) {
            out.println(i+1);
        }
        f.close();
        out.close();
    }
}
