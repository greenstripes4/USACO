import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] adjacencyList;
    private static int[] colors;
    private static int white;
    private static int black;
    private static boolean dfs(int v, boolean c) {
        if(c) {
            colors[v] = 1;
            white++;
        } else {
            colors[v] = 2;
            black++;
        }
        for(int i: adjacencyList[v]) {
            if(colors[i] == 0) {
                if(!dfs(i, !c)) {
                    return false;
                }
            } else if(colors[v] == colors[i]) {
                return false;
            }
        }
        return true;
    }
    private static long modPow(int a, int b) {
        if(b == 0) {
            return 1;
        }
        if(b%2 == 0) {
            long temp = modPow(a, b/2);
            return (temp*temp)%998244353;
        }
        return (modPow(a, b-1)*a)%998244353;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            adjacencyList = new ArrayList[n];
            for(int j = 0; j < n; j++) {
                adjacencyList[j] = new ArrayList<>();
            }
            for(int j = 0; j < m; j++) {
                st = new StringTokenizer(f.readLine());
                int u = Integer.parseInt(st.nextToken())-1;
                int v = Integer.parseInt(st.nextToken())-1;
                adjacencyList[u].add(v);
                adjacencyList[v].add(u);
            }
            colors = new int[n];
            long count = 1;
            for(int j = 0; j < n; j++) {
                if(colors[j] == 0) {
                    white = 0;
                    black = 0;
                    if(dfs(j, true)) {
                        count = ((count*(modPow(2, white)+modPow(2, black))%998244353))%998244353;
                    } else {
                        count = 0;
                        break;
                    }
                }
            }
            out.println(count);
        }
        f.close();
        out.close();
    }
}
