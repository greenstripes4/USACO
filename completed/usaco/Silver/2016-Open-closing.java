import java.io.*;
import java.util.*;

public class Main{
    private static boolean bfs(int source, int target, HashMap<Integer,HashSet<Integer>> paths) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        HashSet<Integer> seen = new HashSet<>();
        seen.add(source);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                if (!queue.isEmpty()) {
                    int temp = queue.poll();
                    if (temp == target) {
                        return true;
                    }
                    for (int j : paths.get(temp)) {
                        if (!seen.contains(j)) {
                            queue.add(j);
                            seen.add(j);
                        }
                    }
                }
            }
        }
        return false;
    }
    private static boolean isConnected(HashMap<Integer,HashSet<Integer>> paths) {
        for(int i: paths.keySet()) {
            for(int j: paths.keySet()) {
                if(!bfs(i,j,paths)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("closing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer,HashSet<Integer>> paths = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            paths.put(i,new HashSet<>());
        }
        for(int i = 0; i < M; i++) {
            StringTokenizer p = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(p.nextToken());
            int b = Integer.parseInt(p.nextToken());
            paths.get(a).add(b);
            paths.get(b).add(a);
        }
        for(int i = 0; i < N; i++) {
            if(isConnected(paths)) {
                out.println("YES");
            } else {
                out.println("NO");
            }
            int closed = Integer.parseInt(f.readLine());
            paths.remove(closed);
            for(int j: paths.keySet()) {
                paths.get(j).remove(closed);
            }
        }
        out.close();
        f.close();
        out.close();
    }
}
