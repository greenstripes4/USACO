import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static String[] words;
    private static StringBuilder res;
    private static void dfs(int root) {
        res.append(words[root]);
        for(int i: adjacencyList.get(root)) {
            dfs(i);
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        words = new String[N];
        for(int i = 0; i < N; i++) {
            words[i] = f.readLine();
        }
        adjacencyList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        int root = -1;
        for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            adjacencyList.get(a).add(b);
            if(i == N-2) {
                root = a;
            }
        }
        res = new StringBuilder();
        dfs(root);
        out.println(res);
        f.close();
        out.close();
    }
}