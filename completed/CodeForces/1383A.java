import java.io.*;
import java.util.*;

public class Main {
    private static int count;
    private static int root(int[] parentIds, int z) {
        while(z != parentIds[z]) {
            parentIds[z] = parentIds[parentIds[z]];
            z = parentIds[z];
        }
        return z;
    }
    private static void union(int[] parentIds, int x, int y) {
        int rootX = root(parentIds, x);
        int rootY = root(parentIds, y);
        if(rootX == rootY) {
            return;
        }
        count++;
        parentIds[rootX] = rootY;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(f.readLine());
            char[] a = f.readLine().toCharArray();
            char[] b = f.readLine().toCharArray();
            boolean valid = true;
            for(int j = 0; j < n; j++) {
                if(a[j] > b[j]) {
                    valid = false;
                    break;
                }
            }
            if(!valid) {
                out.println(-1);
                continue;
            }
            int[] parentIds = new int[21];
            for(int j = 0; j < 21; j++) {
                parentIds[j] = j;
            }
            count = 0;
            for(int j = 0; j < n; j++) {
                if(a[j] != b[j]) {
                    union(parentIds, a[j]-'a', b[j]-'a');
                }
            }
            out.println(count);
        }
        f.close();
        out.close();
    }
}