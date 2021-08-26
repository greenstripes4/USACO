import java.io.*;
import java.util.*;

public class Main {
    private static int[] getPos(String s) {
        char[] arr = s.toCharArray();
        int idx = 0;
        int col = 0;
        while(arr[idx] >= 'A' && arr[idx] <= 'Z') {
            col = col*26+arr[idx++]-'A'+1;
        }
        int row = 0;
        for(int i = idx; i < arr.length; i++) {
            row = row*10+arr[i]-'0';
        }
        return new int[]{row-1, col-1};
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            ArrayList<int[]>[][] adjacencyList = new ArrayList[n][m];
            ArrayList<int[]>[][] reverseAdjacencyList = new ArrayList[n][m];
            Queue<int[]> queue = new LinkedList<>();
            int[][] indegree = new int[n][m];
            getPos("J10");
            int[][] res = new int[n][m];
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(f.readLine());
                for(int j = 0; j < m; j++) {
                    String temp = st.nextToken();
                    if(temp.charAt(0) == '=') {
                        adjacencyList[i][j] = new ArrayList<>();
                        temp = temp.substring(1);
                        String[] addends = temp.split("\\+");
                        for(String k: addends) {
                            int[] prev = getPos(k);
                            adjacencyList[i][j].add(prev);
                            if(reverseAdjacencyList[prev[0]][prev[1]] == null) {
                                reverseAdjacencyList[prev[0]][prev[1]] = new ArrayList<>();
                            }
                            reverseAdjacencyList[prev[0]][prev[1]].add(new int[]{i, j});
                            indegree[i][j]++;
                        }
                    } else {
                        queue.offer(new int[]{i, j});
                        res[i][j] = Integer.parseInt(temp);
                    }
                }
            }
            while(!queue.isEmpty()) {
                int[] cur = queue.poll();
                if(adjacencyList[cur[0]][cur[1]] != null) {
                    for(int[] i: adjacencyList[cur[0]][cur[1]]) {
                        res[cur[0]][cur[1]] += res[i[0]][i[1]];
                    }
                }
                if(reverseAdjacencyList[cur[0]][cur[1]] != null) {
                    for(int[] next: reverseAdjacencyList[cur[0]][cur[1]]) {
                        indegree[next[0]][next[1]]--;
                        if(indegree[next[0]][next[1]] == 0) {
                            queue.offer(next);
                        }
                    }
                }
            }
            for(int i = 0; i < n; i++) {
                out.print(res[i][0]);
                for(int j = 1; j < m; j++) {
                    out.print(" " + res[i][j]);
                }
                out.println();
            }
        }
        f.close();
        out.close();
    }
}
