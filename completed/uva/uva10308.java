import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<int[]>> adjacencyList;
    private static int[] dfs(int root, int parent, int distance) {
        int[] ans = {root, distance};
        for(int[] i: adjacencyList.get(root)) {
            if(i[0] != parent) {
                int[] temp = dfs(i[0], root, distance+i[1]);
                if(temp[1] > ans[1]) {
                    ans = temp;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            ArrayList<int[]> edges = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            edges.add(new int[]{a, b, l});
            int n = Math.max(a, b);
            while((input = f.readLine()) != null && input.length() > 0) {
                st = new StringTokenizer(input);
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                l = Integer.parseInt(st.nextToken());
                edges.add(new int[]{a, b, l});
                n = Math.max(n, Math.max(a, b));
            }
            adjacencyList = new ArrayList<>(n+1);
            for(int i = 0; i <= n; i++) {
                adjacencyList.add(new ArrayList<>());
            }
            for(int[] i: edges) {
                adjacencyList.get(i[0]).add(new int[]{i[1], i[2]});
                adjacencyList.get(i[1]).add(new int[]{i[0], i[2]});
            }
            out.println(dfs(dfs(1, 0, 0)[0], 0, 0)[1]);
        }
        f.close();
        out.close();
    }
}