import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] adjacencyList;
    private static int[][] maxLength;
    private static void dfs1(int root, int parent) {
        for(int i: adjacencyList[root]) {
            if(i != parent) {
                dfs1(i, root);
                if(maxLength[i][1]+1 > maxLength[root][1]) {
                    maxLength[root][2] = maxLength[root][1];
                    maxLength[root][0] = i;
                    maxLength[root][1] = maxLength[i][1]+1;
                } else if(maxLength[i][1]+1 > maxLength[root][2]) {
                    maxLength[root][2] = maxLength[i][1]+1;
                }
            }
        }
    }
    private static void dfs2(int root, int parent) {
        for(int i: adjacencyList[root]) {
            if(i != parent) {
                if(maxLength[root][0] == i) {
                    if(maxLength[root][2]+1 > maxLength[i][1]) {
                        maxLength[i][2] = maxLength[root][1];
                        maxLength[i][0] = root;
                        maxLength[i][1] = maxLength[root][2]+1;
                    } else if(maxLength[root][2]+1 > maxLength[i][2]) {
                        maxLength[i][2] = maxLength[root][2]+1;
                    }
                } else {
                    maxLength[i][2] = maxLength[i][1];
                    maxLength[i][0] = root;
                    maxLength[i][1] = maxLength[root][1]+1;
                }
                dfs2(i, root);
            }
        }
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
        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }
        maxLength = new int[n+1][3];
        dfs1(1, 0);
        dfs2(1, 0);
        out.print(maxLength[1][1]);
        for(int i = 2; i <= n; i++) {
            out.print(" " + maxLength[i][1]);
        }
        out.println();
        f.close();
        out.close();
    }
}