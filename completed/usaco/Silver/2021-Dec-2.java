import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] visited;
    private static ArrayList<ArrayList<Integer>> components;
    private static void dfs(int u, int i) {
        visited[u] = i;
        components.get(i).add(u);
        for(int v: adjacencyList.get(u)) {
            if(visited[v] < 0) {
                dfs(v, i);
            }
        }
    }
    private static int lower(ArrayList<Integer> arr, int tar) {
        int low = 0;
        int high = arr.size()-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr.get(mid) < tar) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    private static int higher(ArrayList<Integer> arr, int tar) {
        int low = 0;
        int high = arr.size()-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr.get(mid) > tar) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    private static long cost(ArrayList<Integer> a, ArrayList<Integer> b) {
        long min = Long.MAX_VALUE;
        if(a.size() < b.size()) {
            for(int i: a) {
                int l = lower(b, i);
                int h = higher(b, i);
                long val;
                if(l < 0) {
                    val = b.get(h)-i;
                } else if(h < 0) {
                    val = i-b.get(l);
                } else {
                    val = Math.min(b.get(h)-i, i-b.get(l));
                }
                min = Math.min(min, val*val);
            }
        } else {
            for(int i: b) {
                int l = lower(a, i);
                int h = higher(a, i);
                long val;
                if(l < 0) {
                    val = a.get(h)-i;
                } else if(h < 0) {
                    val = i-a.get(l);
                } else {
                    val = Math.min(a.get(h)-i, i-a.get(l));
                }
                min = Math.min(min, val*val);
            }
        }
        return min;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            adjacencyList = new ArrayList<>(N);
            for(int i = 0; i < N; i++) {
                adjacencyList.add(new ArrayList<>());
            }
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(f.readLine());
                int u = Integer.parseInt(st.nextToken())-1;
                int v = Integer.parseInt(st.nextToken())-1;
                adjacencyList.get(u).add(v);
                adjacencyList.get(v).add(u);
            }
            visited = new int[N];
            Arrays.fill(visited, -1);
            components = new ArrayList<>();
            int tag = 0;
            for(int i = 0; i < N; i++) {
                if(visited[i] < 0) {
                    components.add(new ArrayList<>());
                    dfs(i, tag++);
                }
            }
            for(ArrayList<Integer> i: components) {
                Collections.sort(i);
            }
            if(visited[N-1] == 0) {
                out.println(0);
            } else {
                long min = cost(components.get(visited[0]), components.get(visited[N-1]));
                for(int i = 1; i < tag; i++) {
                    if(i != visited[N-1]) {
                        min = Math.min(min, cost(components.get(visited[0]), components.get(i))+cost(components.get(i), components.get(visited[N-1])));
                    }
                }
                out.println(min);
            }
        }
        f.close();
        out.close();
    }
}
