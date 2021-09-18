import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] d = new int[n];
        int MAX = 0;
        for(int i = 0; i < n; i++) {
            d[i] = Integer.parseInt(st.nextToken());
            MAX = Math.max(MAX, d[i]);
        }
        ArrayList<ArrayList<Integer>> distance = new ArrayList<>(MAX+1);
        for(int i = 0; i <= MAX; i++) {
            distance.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {
            distance.get(d[i]).add(i);
        }
        int[] degree = new int[n];
        ArrayList<int[]> edges = new ArrayList<>();
        boolean flag = distance.get(0).size() != 1;
        for(int i = 1; i <= MAX; i++) {
            ArrayList<Integer> cur = distance.get(i);
            ArrayList<Integer> prev = distance.get(i-1);
            if(prev.size() == 0) {
                flag = true;
                break;
            }
            int q = cur.size()/prev.size();
            int r = cur.size()%prev.size();
            int idx = 0;
            for(int j = 0; j < r; j++) {
                int u = prev.get(j);
                for(int l = 0; l <= q; l++) {
                    int v = cur.get(idx++);
                    degree[u]++;
                    degree[v]++;
                    edges.add(new int[]{u+1, v+1});
                }
            }
            for(int j = r; j < prev.size(); j++) {
                int u = prev.get(j);
                for(int l = 0; l < q; l++) {
                    int v = cur.get(idx++);
                    degree[u]++;
                    degree[v]++;
                    edges.add(new int[]{u+1, v+1});
                }
            }
        }
        for(int i: degree) {
            if(i > k) {
                flag = true;
                break;
            }
        }
        if(flag) {
            out.println(-1);
        } else {
            out.println(edges.size());
            for(int[] e: edges) {
                out.println(e[0] + " " + e[1]);
            }
        }
        f.close();
        out.close();
    }
}