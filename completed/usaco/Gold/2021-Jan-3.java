import java.io.*;
import java.util.*;

public class Main {
    private static void addSet(HashMap<Integer, Integer> map, HashSet<Integer> set) {
        for(int i: set) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
    }
    private static void removeSet(HashMap<Integer, Integer> map, HashSet<Integer> set) {
        for(int i: set) {
            map.put(i, map.get(i)-1);
            if(map.get(i) == 0) {
                map.remove(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        int[] p = new int[N];
        ArrayList<HashSet<Integer>> occupied = new ArrayList<>(N);
        for(int i = 0; i < N; i++) {
            p[i] = i;
            occupied.add(new HashSet<>());
            occupied.get(i).add(i);
        }
        ArrayList<HashSet<Integer>> mod = new ArrayList<>(N);
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            occupied.get(p[a]).add(b);
            occupied.get(p[b]).add(a);
            int temp = p[a];
            p[a] = p[b];
            p[b] = temp;
            if((i+1)%K == M%K) {
                for(int j = 0; j < N; j++) {
                    mod.add(new HashSet<>(occupied.get(j)));
                }
            }
        }
        ArrayList<ArrayList<Integer>> cycles = new ArrayList<>();
        boolean[] visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                ArrayList<Integer> arr = new ArrayList<>();
                visited[i] = true;
                arr.add(i);
                int j = p[i];
                while(j != i) {
                    visited[j] = true;
                    arr.add(j);
                    j = p[j];
                }
                Collections.reverse(arr);
                cycles.add(arr);
            }
        }
        int[] res = new int[N];
        for(ArrayList<Integer> cycle: cycles) {
            if(M/K >= cycle.size()) {
                HashSet<Integer> set = new HashSet<>();
                for(int i: cycle) {
                    set.addAll(occupied.get(i));
                }
                for(int i: cycle) {
                    res[i] = set.size();
                }
            } else {
                HashMap<Integer, Integer> occ = new HashMap<>();
                for(int i = 0; i < M/K; i++) {
                    addSet(occ, occupied.get(cycle.get(i)));
                }
                for(int i = 0; i < cycle.size(); i++) {
                    int j = (int) ((i+M/K)%cycle.size());
                    if(M%K > 0) {
                        addSet(occ, mod.get(cycle.get(j)));
                    }
                    res[cycle.get(i)] = occ.size();
                    if(M/K > 0) {
                        removeSet(occ, occupied.get(cycle.get(i)));
                    }
                    if(M%K > 0) {
                        removeSet(occ, mod.get(cycle.get(j)));
                    }
                    if(M/K > 0) {
                        addSet(occ, occupied.get(cycle.get(j)));
                    }
                }
            }
        }
        for(int i: res) {
            out.println(i);
        }
        f.close();
        out.close();
    }
}
