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
        int k = Integer.parseInt(st.nextToken());
        int[] parentIds = new int[n];
        int[] groupSizes = new int[n];
        for(int i = 0; i < n; i++) {
            parentIds[i] = i;
            groupSizes[i] = 1;
        }
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            union(parentIds, groupSizes, x, y);
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(i == root(parentIds, i)) {
                count++;
            }
        }
        out.println(k-n+count);
        f.close();
        out.close();
    }
}
