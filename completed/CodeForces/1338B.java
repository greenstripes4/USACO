import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] adjacencyList;
    private static int dfs(int root, int parent, int depth) {
        boolean[] parity = new boolean[2];
        for(int i: adjacencyList[root]) {
            if(i != parent) {
                int temp = dfs(i, root, depth+1);
                if(temp == 2) {
                    return 2;
                }
                parity[temp] = true;
            }
        }
        if(parity[0] && parity[1]) {
            return 2;
        }
        if(!parity[0] && !parity[1]) {
            parity[depth%2] = true;
        }
        return parity[0] ? 0 : 1;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        adjacencyList = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        int[] degree = new int[n+1];
        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
            degree[a]++;
            degree[b]++;
        }
        int temp = dfs(1, 0, 0);
        int min = temp == 2 || (degree[1] == 1 && temp > 0) ? 3 : 1;
        int max = n-1;
        for(int i = 1; i <= n; i++) {
            if(degree[i] == 1) {
                max--;
            } else {
                for(int j: adjacencyList[i]) {
                    if(degree[j] == 1) {
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