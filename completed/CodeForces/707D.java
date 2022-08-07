import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static boolean[][] arr;
    private static int ans;
    private static int[][] queries;
    private static int[] res;
    private static void dfs(int u) {
        res[u] = ans;
        for(int v: adjacencyList.get(u)) {
            boolean flag = false;
            if(queries[v][0] == 1) {
                if(!arr[queries[v][1]-1][queries[v][2]-1]) {
                    flag = true;
                    arr[queries[v][1]-1][queries[v][2]-1] = true;
                    ans++;
                }
            } else if(queries[v][0] == 2) {
                if(arr[queries[v][1]-1][queries[v][2]-1]) {
                    flag = true;
                    arr[queries[v][1]-1][queries[v][2]-1] = false;
                    ans--;
                }
            } else if(queries[v][0] == 3) {
                flag = true;
                for(int i = 0; i < arr[queries[v][1]-1].length; i++) {
                    if(arr[queries[v][1]-1][i]) {
                        ans--;
                    } else {
                        ans++;
                    }
                    arr[queries[v][1]-1][i] = !arr[queries[v][1]-1][i];
                }
            }
            dfs(v);
            if(flag) {
                if(queries[v][0] == 1) {
                    arr[queries[v][1]-1][queries[v][2]-1] = false;
                    ans--;
                } else if(queries[v][0] == 2) {
                    arr[queries[v][1]-1][queries[v][2]-1] = true;
                    ans++;
                } else if(queries[v][0] == 3) {
                    for(int i = 0; i < arr[queries[v][1]-1].length; i++) {
                        if(arr[queries[v][1]-1][i]) {
                            ans--;
                        } else {
                            ans++;
                        }
                        arr[queries[v][1]-1][i] = !arr[queries[v][1]-1][i];
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList<>(q+1);
        for(int i = 0; i <= q; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        queries = new int[q+1][3];
        int p = 0;
        for(int i = 1; i <= q; i++) {
            st = new StringTokenizer(f.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken());
            if(queries[i][0] == 1 || queries[i][0] == 2) {
                queries[i][2] = Integer.parseInt(st.nextToken());
            } else if(queries[i][0] == 4) {
                p = queries[i][1];
            }
            adjacencyList.get(p).add(i);
            p = i;
        }
        arr = new boolean[n][m];
        ans = 0;
        res = new int[q+1];
        dfs(0);
        for(int i = 1; i <= q; i++) {
            out.println(res[i]);
        }
        f.close();
        out.close();
    }
}