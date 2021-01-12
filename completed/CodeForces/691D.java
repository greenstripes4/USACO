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
        int[] p = new int[n];
        int[] parentIds = new int[n];
        int[] groupSizes = new int[n];
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            parentIds[i] = i;
            groupSizes[i] = 1;
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            union(parentIds, groupSizes, a, b);
        }
        ArrayList<Integer>[] originalComponents = new ArrayList[n];
        ArrayList<Integer>[] sortedComponents = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            originalComponents[i] = new ArrayList<>();
            sortedComponents[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++) {
            int rootI = root(parentIds, i);
            originalComponents[rootI].add(i);
            sortedComponents[rootI].add(i);
        }
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            Collections.sort(sortedComponents[i], new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return p[t1]-p[integer];
                }
            });
            for(int j = 0; j < originalComponents[i].size(); j++) {
                ans[originalComponents[i].get(j)] = p[sortedComponents[i].get(j)];
            }
        }
        out.print(ans[0]);
        for(int i = 1; i < n; i++) {
            out.print(" " + ans[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}
