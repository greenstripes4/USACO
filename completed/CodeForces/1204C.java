import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        char[][] adjacencyMatrix = new char[n][];
        for(int i = 0; i < n; i++) {
            adjacencyMatrix[i] = f.readLine().toCharArray();
        }
        int m = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] p = new int[m];
        for(int i = 0; i < m; i++) {
            p[i] = Integer.parseInt(st.nextToken())-1;
        }
        int[][] d = new int[n][n];
        for(int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            Arrays.fill(d[i], -1);
            queue.offer(i);
            d[i][i] = 0;
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                for(int next = 0; next < n; next++) {
                    if(adjacencyMatrix[cur][next] == '1' && d[i][next] < 0) {
                        queue.offer(next);
                        d[i][next] = d[i][cur]+1;
                    }
                }
            }
        }
        ArrayList<Integer> v = new ArrayList<>();
        v.add(0);
        for(int i = 1; i < m; i++) {
            int prev = v.get(v.size()-1);
            if(d[p[prev]][p[i]] < i-prev) {
                v.add(i-1);
            }
        }
        v.add(m-1);
        out.println(v.size());
        out.print(p[v.get(0)]+1);
        for(int i = 1; i < v.size(); i++) {
            out.print(" " + (p[v.get(i)]+1));
        }
        out.println();
        f.close();
        out.close();
    }
}