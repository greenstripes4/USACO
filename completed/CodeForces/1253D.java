import java.io.*;
import java.util.*;

public class Main {
    private static int root(int[] parentIds, int c) {
        while(c != parentIds[c]) {
            parentIds[c] = parentIds[parentIds[c]];
            c = parentIds[c];
        }
        return c;
    }
    private static void union(int[] parentIds, int[] groupSizes, int a, int b) {
        int rootA = root(parentIds, a);
        int rootB = root(parentIds, b);
        if(rootA == rootB) {
            return;
        }
        if(groupSizes[rootA] < groupSizes[rootB]) {
            parentIds[rootA] = rootB;
            groupSizes[rootB] += groupSizes[rootA];
        } else {
            parentIds[rootB] = rootA;
            groupSizes[rootA] += groupSizes[rootB];
        }
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] parentIds = new int[n];
        int[] groupSizes = new int[n];
        for(int i = 0; i < n; i++) {
            parentIds[i] = i;
            groupSizes[i] = 1;
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            union(parentIds, groupSizes, u, v);
        }
        int[][] minMax = new int[n][2];
        for(int[] i: minMax) {
            i[0] = 200000;
            i[1] = -1;
        }
        for(int i = 0; i < n; i++) {
            int rootI = root(parentIds, i);
            minMax[rootI][0] = Math.min(minMax[rootI][0], i);
            minMax[rootI][1] = Math.max(minMax[rootI][1], i);
        }
        Arrays.sort(minMax, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0]-t1[0];
            }
        });
        int max = -1;
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(minMax[i][0] < max) {
                count++;
            }
            max = Math.max(max, minMax[i][1]);
        }
        out.println(count);
        f.close();
        out.close();
    }
}
