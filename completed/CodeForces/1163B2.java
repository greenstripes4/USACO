import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        int[] occ = new int[100001];
        StringTokenizer st = new StringTokenizer(f.readLine());
        int max = 0;
        for(int i = 0; i < n; i++) {
            int u = Integer.parseInt(st.nextToken());
            if(occ[u] == 0) {
                map.putIfAbsent(1, new HashSet<>());
                map.get(1).add(u);
                occ[u] = 1;
            } else {
                map.get(occ[u]).remove(u);
                if(map.get(occ[u]).size() == 0) {
                    map.remove(occ[u]);
                }
                map.putIfAbsent(occ[u]+1, new HashSet<>());
                map.get(occ[u]+1).add(u);
                occ[u]++;
            }
            int maxKey = 0;
            int minKey = 100001;
            int sum = 0;
            for(int j: map.keySet()) {
                maxKey = Math.max(maxKey, j);
                minKey = Math.min(minKey, j);
                sum += map.get(j).size();
            }
            if(maxKey == 1 || sum == 1) {
                max = Math.max(max, i+1);
                continue;
            }
            if(map.size() == 2 && ((minKey == 1 && map.get(1).size() == 1) || (maxKey == minKey+1 && map.get(maxKey).size() == 1))) {
                max = Math.max(max, i+1);
            }
        }
        out.println(max);
        f.close();
        out.close();
    }
}