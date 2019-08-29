import java.io.*;
import java.util.*;

public class Main{
    public static int bfs(int[][] graph, int[] start){
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> next = new LinkedList<>();
        queue.add(start);
        boolean[][] visited = new boolean[graph.length][graph.length];
        int count = 0;
        while(!queue.isEmpty()){
            count++;
            while(!queue.isEmpty()){
                int[] curPos = queue.poll();
                int[] up = new int[]{curPos[0],curPos[1]+1};
                int[] down = new int[]{curPos[0],curPos[1]-1};
                int[] right = new int[]{curPos[0]+1,curPos[1]};
                int[] left = new int[]{curPos[0]-1,curPos[1]};
                if(up[0] >= 0 && up[0] < graph.length && up[1] >= 0 && up[1] < graph.length && !visited[up[0]][up[1]]){
                    visited[up[0]][up[1]] = true;
                    next.add(up);
                }
                if(down[0] >= 0 && down[0] < graph.length && down[1] >= 0 && down[1] < graph.length && !visited[down[0]][down[1]]){
                    visited[down[0]][down[1]] = true;
                    next.add(down);
                }
                if(right[0] >= 0 && right[0] < graph.length && right[1] >= 0 && right[1] < graph.length && !visited[right[0]][right[1]]){
                    visited[right[0]][right[1]] = true;
                    next.add(right);
                }
                if(left[0] >= 0 && left[0] < graph.length && left[1] >= 0 && left[1] < graph.length && !visited[left[0]][left[1]]){
                    visited[left[0]][left[1]] = true;
                    next.add(left);
                }
            }
            for(int[] i: next){
                if(graph[i[0]][i[1]] == 3){
                    return count;
                }
            }
            queue = next;
            next = new LinkedList<>();
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null){
            int side = Integer.parseInt(input);
            int[][] field = new int[side][side];
            for(int i = 0; i < side; i++){
                int temp = Integer.parseInt(f.readLine());
                for(int j = 0; j < side; j++){
                    field[i][side-j-1] = temp%10;
                    temp /= 10;
                }
            }
            int max = 0;
            for(int k = 0; k < side; k++){
                for(int l = 0; l < side; l++){
                    if(field[k][l] == 1){
                        max = Math.max(max,bfs(field,new int[]{k,l}));
                    }
                }
            }
            out.println(max);
        }
        out.close();
        f.close();
    }
}
