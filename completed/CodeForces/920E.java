import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<HashSet<Integer>> adjacencyList;
    private static HashSet<Integer> set;
    private static int temp;
    private static void bfs(int u) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(u);
        set.remove(u);
        temp++;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            ArrayList<Integer> remove = new ArrayList<>();
            for(int v: set) {
                if(!adjacencyList.get(cur).contains(v)) {
                    queue.offer(v);
                    temp++;
                    remove.add(v);
                }
            }
            for(int i: remove) {
                set.remove(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList<>(n);
        set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new HashSet<>());
            set.add(i);
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }
        int count = 0;
        ArrayList<Integer> sizes = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(set.contains(i)) {
                count++;
                temp = 0;
                bfs(i);
                sizes.add(temp);
            }
        }
        out.println(count);
        Collections.sort(sizes);
        out.print(sizes.get(0));
        for(int i = 1; i < count; i++) {
            out.print(" " + sizes.get(i));
        }
        out.println();
        f.close();
        out.close();
    }
}