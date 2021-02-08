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
    private static boolean union(int[] parentIds, int[] groupSizes, int a, int b) {
        int rootA = root(parentIds, a);
        int rootB = root(parentIds, b);
        if(rootA == rootB) {
            return false;
        }
        if(groupSizes[rootA] < groupSizes[rootB]) {
            parentIds[rootA] = rootB;
            groupSizes[rootB] += groupSizes[rootA];
        } else {
            parentIds[rootB] = rootA;
            groupSizes[rootA] += groupSizes[rootB];
        }
        return true;
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
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            union(parentIds, groupSizes, a, b);
        }
        ArrayList<Integer> roots = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(root(parentIds, i) == i) {
                roots.add(i+1);
            }
        }
        out.println(roots.size()-1);
        for(int i = 1; i < roots.size(); i++) {
            out.println(roots.get(i-1) + " " + roots.get(i));
        }
        f.close();
        out.close();
    }
}