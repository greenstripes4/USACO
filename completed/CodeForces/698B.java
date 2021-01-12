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
        int n = Integer.parseInt(f.readLine());
        int[] a = new int[n];
        int[] parentIds = new int[n];
        int[] groupSizes = new int[n];
        StringTokenizer st = new StringTokenizer(f.readLine());
        int r = -1;
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken())-1;
            parentIds[i] = i;
            groupSizes[i] = i;
            if(i == a[i]) {
                r = i;
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(i != a[i] && !union(parentIds, groupSizes, i, a[i])) {
                a[i] = r == -1 ? i : r;
                count++;
            }
            if(i == a[i] && r == -1) {
                r = a[i];
            }
        }
        for(int i = 0; i < n; i++) {
            if(i == a[i] && i != r) {
                a[i] = r;
                count++;
            }
        }
        out.println(count);
        out.print(a[0]+1);
        for(int i = 1; i < n; i++) {
            out.print(" " + (a[i]+1));
        }
        out.println();
        f.close();
        out.close();
    }
}
