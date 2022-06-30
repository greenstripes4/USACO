import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static ArrayList<ArrayList<int[]>> adjacencyList;
    private static int[] depth;
    private static int[] subtreeSize;
    private static long sum;
    private static void dfs1(int u, int p, int d, int dist) {
        depth[u] = d;
        subtreeSize[u] = 1;
        sum += dist;
        for(int[] v: adjacencyList.get(u)) {
            if(v[0] != p) {
                dfs1(v[0], u, d+1, dist+v[1]);
                subtreeSize[u] += subtreeSize[v[0]];
            }
        }
    }
    private static void dfs2(int u, int p, long distP, int lenP) {
        if(u > 0) {
            distP -= subtreeSize[u]*(long) lenP;
            distP += (n-subtreeSize[u])*(long) lenP;
            sum += distP;
        }
        for(int[] v: adjacencyList.get(u)) {
            if(v[0] != p) {
                dfs2(v[0], u, distP, v[1]);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        n = Integer.parseInt(f.readLine());
        adjacencyList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        int[][] edges = new int[n-1][3];
        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken())-1;
            edges[i][1] = Integer.parseInt(st.nextToken())-1;
            edges[i][2] = Integer.parseInt(st.nextToken());
            adjacencyList.get(edges[i][0]).add(new int[]{edges[i][1], edges[i][2]});
            adjacencyList.get(edges[i][1]).add(new int[]{edges[i][0], edges[i][2]});
        }
        depth = new int[n];
        subtreeSize = new int[n];
        sum = 0;
        dfs1(0, -1, 0, 0);
        dfs2(0, -1, sum, 0);
        sum /= 2;
        long total = n*(long) (n-1);
        int q = Integer.parseInt(f.readLine());
        for(int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());
            int diff = edges[r][2]-w;
            edges[r][2] = w;
            if(depth[edges[r][0]] < depth[edges[r][1]]) {
                sum -= diff*subtreeSize[edges[r][1]]*(long) (n-subtreeSize[edges[r][1]]);
            } else {
                sum -= diff*subtreeSize[edges[r][0]]*(long) (n-subtreeSize[edges[r][0]]);
            }
            out.println(sum*6.0/total);
        }
        f.close();
        out.close();
    }
}