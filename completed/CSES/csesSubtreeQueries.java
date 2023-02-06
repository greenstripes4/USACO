import java.io.*;
import java.util.*;

public class Main {
        private static ArrayList<ArrayList<Integer>> adjacencyList;
        private static int[] preOrder;
        private static int[] pos;
        private static int[] size;
        private static int idx;
        private static void dfs(int u, int p) {
                pos[u] = idx;
                preOrder[idx++] = u;
                size[u] = 1;
                for(int v: adjacencyList.get(u)) {
                        if(v != p) {
                                dfs(v, u);
                                size[u] += size[v];
                        }
                }
        }
        private static long[] BIT;
        private static void update(int index, int add) {
                while(index < BIT.length) {
                        BIT[index] += add;
                        index += index&-index;
                }
        }
        private static long query(int index) {
                long sum = 0;
                while(index > 0) {
                        sum += BIT[index];
                        index -= index&-index;
                }
                return sum;
        }
        public static void main(String[] args) throws IOException {
                BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
                //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
                //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));
                StringTokenizer st = new StringTokenizer(f.readLine());
                int n = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());
                st = new StringTokenizer(f.readLine());
                int[] val = new int[n];
                for(int i = 0; i < n; i++) {
                        val[i] = Integer.parseInt(st.nextToken());
                }
                adjacencyList = new ArrayList<>(n);
                for(int i = 0; i < n; i++) {
                        adjacencyList.add(new ArrayList<>());
                }
                for(int i = 0; i < n-1; i++) {
                        st = new StringTokenizer(f.readLine());
                        int u = Integer.parseInt(st.nextToken())-1;
                        int v = Integer.parseInt(st.nextToken())-1;
                        adjacencyList.get(u).add(v);
                        adjacencyList.get(v).add(u);
                }
                preOrder = new int[n];
                pos = new int[n];
                size = new int[n];
                idx = 0;
                dfs(0, -1);
                int[] arr = new int[n];
                for(int i = 0; i < n; i++) {
                        arr[i] = val[preOrder[i]];
                }
                BIT = new long[n+1];
                for(int i = 1; i <= n; i++) {
                        update(i, arr[i-1]);
                }
                for(int i = 0; i < q; i++) {
                        st = new StringTokenizer(f.readLine());
                        if(Integer.parseInt(st.nextToken()) == 1) {
                                int s = Integer.parseInt(st.nextToken())-1;
                                int v = Integer.parseInt(st.nextToken());
                                update(pos[s]+1, v-arr[pos[s]]);
                                arr[pos[s]] = v;
                        } else {
                                int s = Integer.parseInt(st.nextToken())-1;
                                out.println(query(pos[s]+size[s])-query(pos[s]));
                        }
                }
                f.close();
                out.close();
        }
}
