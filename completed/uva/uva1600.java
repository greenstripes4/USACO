import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int dataSets = Integer.parseInt(f.readLine());
        for(int d = 0; d < dataSets; d++) {
            StringTokenizer dimensions = new StringTokenizer(f.readLine());
            int m = Integer.parseInt(dimensions.nextToken());
            int n = Integer.parseInt(dimensions.nextToken());
            int k = Integer.parseInt(f.readLine());
            int[][] a = new int[m][n];
            for(int i = 0; i < m; i++) {
                StringTokenizer row = new StringTokenizer(f.readLine());
                for(int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(row.nextToken());
                }
            }
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0,0,k});
            int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
            int[][][] visited = new int[m][n][k+1];
            visited[0][0][k] = 1;
            int steps = 0;
            boolean found = false;
            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int i = 0; i < size; i++) {
                    int[] temp = queue.poll();
                    if(temp[0] == m-1 && temp[1] == n-1) {
                        found = true;
                        break;
                    }
                    for(int[] j: directions) {
                        if(temp[0]+j[0] >= 0 && temp[0]+j[0] < m && temp[1]+j[1] >= 0 && temp[1]+j[1] < n && visited[temp[0]+j[0]][temp[1]+j[1]][temp[2]] == 0) {
                            if(a[temp[0]+j[0]][temp[1]+j[1]] == 1 && temp[2] > 0 && visited[temp[0]+j[0]][temp[1]+j[1]][temp[2]-1] == 0) {
                                queue.add(new int[]{temp[0]+j[0],temp[1]+j[1],temp[2]-1});
                                visited[temp[0]+j[0]][temp[1]+j[1]][temp[2]-1] = 1;
                            } else if(a[temp[0]+j[0]][temp[1]+j[1]] == 0 && visited[temp[0]+j[0]][temp[1]+j[1]][temp[2]] == 0) {
                                queue.add(new int[]{temp[0]+j[0],temp[1]+j[1],k});
                                visited[temp[0]+j[0]][temp[1]+j[1]][temp[2]] = 1;
                            }
                        }
                    }
                }
                if(found) {
                    break;
                }
                steps++;
            }
            if(found) {
                out.println(steps);
            } else {
                out.println(-1);
            }
        }
        f.close();
        out.close();
    }
}
