import java.io.*;
import java.util.*;

public class Main{
    public static int[] findFirst(char[][] hide) {
        int[] start = new int[2];
        for(int i = 0; i < hide.length; i++){
            for(int j = 0; j < hide[0].length; j++){
                if(hide[i][j] == 'X'){
                    start[0] = i;
                    start[1] = j;
                    return start;
                }
            }
        }
        return null;
    }
    
    public static ArrayList<int[]> bfs(char[][] hide){
        int[] start = findFirst(hide);
        ArrayList<int[]> spot1 = new ArrayList<>();
        spot1.add(start);
        hide[start[0]][start[1]] = '.';
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> next = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            while(!queue.isEmpty()) {
                int[] curPos = queue.poll();
                int[] up = new int[]{curPos[0], curPos[1] + 1};
                int[] down = new int[]{curPos[0], curPos[1] - 1};
                int[] right = new int[]{curPos[0] + 1, curPos[1]};
                int[] left = new int[]{curPos[0] - 1, curPos[1]};
                int[][] directions = new int[][]{up,down,left,right};
                for(int[] dir: directions){
                    if(dir[0] >= 0 && dir[0] < hide.length && dir[1] >= 0 && dir[1] < hide[0].length && hide[dir[0]][dir[1]] == 'X'){
                        hide[dir[0]][dir[1]] = '.';
                        next.add(new int[]{dir[0],dir[1]});
                        spot1.add(new int[]{dir[0],dir[1]});
                    }
                }
            }
            queue = next;
            next = new LinkedList<>();
        }
        return spot1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("pageant.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pageant.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] hide = new char[n][m];
        for(int i = 0; i < n; i++){
            char[] temp = f.readLine().toCharArray();
            hide[i] = temp;
        }
        ArrayList<int[]> first = bfs(hide);
        ArrayList<int[]> second = bfs(hide);
        int minDistance = Integer.MAX_VALUE;
        for(int[] pos1: first){
            for(int[] pos2: second){
                minDistance = Math.min(minDistance, Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]));
            }
        }
        out.println(minDistance - 1);
        out.close();
        f.close();
    }
}
