import java.io.*;
import java.util.*;

public class Main{
    private static int root(int[] leaderIds, int z) {
        while(z != leaderIds[z]) {
            leaderIds[z] = leaderIds[leaderIds[z]];
            z = leaderIds[z];
        }
        return z;
    }
    private static void union(int[] leaderIds, int[] groupSizes, int x, int y) {
        int rootX = root(leaderIds,x);
        int rootY = root(leaderIds,y);
        if(groupSizes[rootX] > groupSizes[rootY]) {
            leaderIds[rootY] = rootX;
            groupSizes[rootX] += groupSizes[rootY];
        } else {
            leaderIds[rootX] = rootY;
            groupSizes[rootY] += groupSizes[rootX];
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        for(int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] leaderIds = new int[n];
            int[] groupSizes = new int[n];
            int[] amounts = new int[n];
            for(int i = 0; i < n; i++) {
                leaderIds[i] = i;
                groupSizes[i] = 1;
                amounts[i] = Integer.parseInt(f.readLine());
            }
            for(int i = 0; i < m; i++) {
                StringTokenizer line = new StringTokenizer(f.readLine());
                int x = Integer.parseInt(line.nextToken());
                int y = Integer.parseInt(line.nextToken());
                union(leaderIds,groupSizes,x,y);
            }
            boolean[] visited = new boolean[n];
            boolean possible = true;
            for(int i = 0; i < n; i++) {
                if(!visited[i]) {
                    int sum = 0;
                    int rootI = root(leaderIds,i);
                    for(int j = 0; j < n; j++) {
                        if(rootI == root(leaderIds,j)) {
                            sum += amounts[j];
                            visited[j] = true;
                        }
                    }
                    if(sum != 0) {
                        out.println("IMPOSSIBLE");
                        possible = false;
                        break;
                    }
                }
            }
            if(possible) {
                out.println("POSSIBLE");
            }
        }
        f.close();
        out.close();
    }
}
