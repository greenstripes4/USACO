import java.io.*;
import java.util.*;

public class Main{
    private static int root(int[] parentIds, int a) {
        while(a != parentIds[a]) {
            parentIds[a] = parentIds[parentIds[a]];
            a = parentIds[a];
        }
        return a;
    }
    private static void union(int[] parentIds, int[] groupSizes, int a, int b) {
        int rootA = root(parentIds, a);
        int rootB = root(parentIds, b);
        if(groupSizes[rootA] < groupSizes[rootB]) {
            parentIds[rootA] = rootB;
            groupSizes[rootB] += groupSizes[rootA];
        } else {
            parentIds[rootB] = rootA;
            groupSizes[rootA] += groupSizes[rootB];
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            LinkedList<int[]> roads = new LinkedList<>();
            int maxPPA = Integer.MIN_VALUE;
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(f.readLine());
                int[] road = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
                int PPA = Integer.parseInt(st.nextToken());
                if(PPA > maxPPA) {
                    roads.clear();
                    roads.add(road);
                    maxPPA = PPA;
                } else if(PPA == maxPPA) {
                    roads.add(road);
                }
            }
            int[] parentIds = new int[n+1];
            int[] groupSizes = new int[n+1];
            for(int i = 1; i <= n; i++) {
                parentIds[i] = i;
                groupSizes[i] = 1;
            }
            for(int[] i: roads) {
                union(parentIds, groupSizes, i[0], i[1]);
            }
            int maxGroupSize = 0;
            boolean[] visited = new boolean[n+1];
            for(int i = 1; i <= n; i++) {
                if(!visited[i]) {
                    int rootI = root(parentIds, i);
                    int groupSize = 0;
                    for(int j = 1; j <= n; j++) {
                        if(rootI == root(parentIds, j)) {
                            visited[j] = true;
                            groupSize++;
                        }
                    }
                    maxGroupSize = Math.max(maxGroupSize, groupSize);
                }
            }
            out.println(maxGroupSize);
        }
        f.close();
        out.close();
    }
}
