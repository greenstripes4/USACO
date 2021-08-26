import java.io.*;
import java.util.*;

public class Main {
    private static class Struct {
        private String op;
        private int[] prev;
        private Struct(String op, int[] prev) {
            this.op = op;
            this.prev = prev;
        }
    }
    private static void backtrack(int[] cur, Struct[][] visited, PrintWriter out) {
        if(cur[0] == 0 && cur[1] == 0) {
            return;
        }
        backtrack(visited[cur[0]][cur[1]].prev, visited, out);
        out.println(visited[cur[0]][cur[1]].op);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            Queue<int[]> queue = new LinkedList<>();
            Struct[][] visited = new Struct[a+1][b+1];
            queue.offer(new int[]{0, 0});
            visited[0][0] = new Struct("", new int[2]);
            int[] res = new int[2];
            while(!queue.isEmpty()) {
                int[] cur = queue.poll();
                if(cur[1] == N) {
                    res = cur;
                    break;
                }
                if(visited[a][cur[1]] == null) {
                    queue.offer(new int[]{a, cur[1]});
                    visited[a][cur[1]] = new Struct("fill A", cur);
                }
                if(visited[cur[0]][b] == null) {
                    queue.offer(new int[]{cur[0], b});
                    visited[cur[0]][b] = new Struct("fill B", cur);
                }
                if(visited[0][cur[1]] == null) {
                    queue.offer(new int[]{0, cur[1]});
                    visited[0][cur[1]] = new Struct("empty A", cur);
                }
                if(visited[cur[0]][0] == null) {
                    queue.offer(new int[]{cur[0], 0});
                    visited[cur[0]][0] = new Struct("empty B", cur);
                }
                int remove = Math.min(cur[0], b-cur[1]);
                if(visited[cur[0]-remove][cur[1]+remove] == null) {
                    queue.offer(new int[]{cur[0]-remove, cur[1]+remove});
                    visited[cur[0]-remove][cur[1]+remove] = new Struct("pour A B", cur);
                }
                remove = Math.min(cur[1], a-cur[0]);
                if(visited[cur[0]+remove][cur[1]-remove] == null) {
                    queue.offer(new int[]{cur[0]+remove, cur[1]-remove});
                    visited[cur[0]+remove][cur[1]-remove] = new Struct("pour B A", cur);
                }
            }
            backtrack(res, visited, out);
            out.println("success");
        }
        f.close();
        out.close();
    }
}