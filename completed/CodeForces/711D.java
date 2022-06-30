import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<HashSet<Integer>> adjacencyList;
    private static boolean[] visited;
    private static boolean[] inCycle;
    private static int[] parent;
    private static int ans;
    private static void dfs(int root) {
        if(visited[root]) {
            int cycleLength = 1;
            inCycle[root] = true;
            int temp = parent[root];
            while(root != temp) {
                cycleLength++;
                inCycle[temp] = true;
                temp = parent[temp];
            }
            ans = multiply(ans, subtract(power(2, cycleLength), 2));
            return;
        }
        visited[root] = true;
        for(int i: adjacencyList.get(root)) {
            if(i != parent[root]) {
                if(!inCycle[i]) {
                    parent[i] = root;
                    dfs(i);
                }
                if(inCycle[root]) {
                    return;
                }
                ans = multiply(ans, 2);
            }
        }
    }
    private static final int MOD = 1000000007;
    private static int add(long a, long b) { return (int) (((a+MOD)%MOD+(b+MOD)%MOD)%MOD); }
    private static int subtract(long a, long b) {
        return add(a, -b);
    }
    private static int multiply(long a, long b) {
        return (int) (((a%MOD)*(b%MOD))%MOD);
    }
    private static int power(long a, long b) {
        long c = 1;
        while(b > 0) {
            if((b&1) > 0) {
                c = multiply(c, a);
            }
            a = multiply(a, a);
            b >>= 1;
        }
        return (int) c;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        adjacencyList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new HashSet<>());
        }
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken())-1;
            adjacencyList.get(i).add(a);
            adjacencyList.get(a).add(i);
        }
        visited = new boolean[n];
        inCycle = new boolean[n];
        parent = new int[n];
        Arrays.fill(parent, -1);
        ans = 1;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i);
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}