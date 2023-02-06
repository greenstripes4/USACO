import java.io.*;
import java.util.*;

public class Main {
    private static HashMap<Integer, HashSet<Integer>> p = new HashMap<>();
    private static int[] dx = {-1, 0, 0, 1};
    private static int[] dy = {0, -1, 1, 0};
    private static boolean contains(HashMap<Integer, HashSet<Integer>> p, int x, int y) {
        return p.containsKey(x) && p.get(x).contains(y);
    }
    private static boolean add(HashMap<Integer, HashSet<Integer>> p, int x, int y) {
        if(contains(p, x, y)) {
            return true;
        }
        if(!p.containsKey(x)) {
            p.put(x, new HashSet<>());
        }
        p.get(x).add(y);
        return false;
    }
    private static void addNeighbors(Queue<Integer> qx, Queue<Integer> qy, HashMap<Integer, HashSet<Integer>> visited, int x, int y) {
        qx.add(x);
        qy.add(y);
        add(visited, x, y);
        for(int i = 0; i < 4; i++) {
            if(contains(p, x+dx[i], y+dy[i]) && !contains(visited, x+dx[i], y+dy[i])) {
                qx.add(x+dx[i]);
                qy.add(y+dy[i]);
                add(visited, x, y);
            }
        }
    }
    private static int process(int x, int y) {
        if(add(p, x, y)) {
            return -1;
        }
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        HashMap<Integer, HashSet<Integer>> visited = new HashMap<>();
        addNeighbors(qx, qy, visited, x, y);
        int count = 0;
        while(!qx.isEmpty()) {
            x = qx.poll();
            y = qy.poll();
            int temp = missing(x, y);
            if(temp < 0) {
                continue;
            }
            x += dx[temp];
            y += dy[temp];
            add(p, x, y);
            count++;
            addNeighbors(qx, qy, visited, x, y);
        }
        return count;
    }
    private static int missing(int x, int y) {
        int ans = -1;
        for(int i = 0; i < 4; i++) {
            if(!contains(p, x+dx[i], y+dy[i])) {
                if(ans < 0) {
                    ans = i;
                } else {
                    ans = -1;
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        int total = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            total += process(x, y);
            out.println(total);
        }
        f.close();
        out.close();
    }
}