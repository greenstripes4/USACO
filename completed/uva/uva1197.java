import java.io.*;
import java.util.*;

public class Main{
    private static int root(int[] leaderIds, int p) {
        while(p != leaderIds[p]) {
            leaderIds[p] = leaderIds[leaderIds[p]];
            p = leaderIds[p];
        }
        return p;
    }
    private static void union(int[] leaderIds, int[] groupSizes, int p, int q) {
        int rootP = root(leaderIds,p);
        int rootQ = root(leaderIds,q);
        if(groupSizes[rootP] < groupSizes[rootQ]) {
            leaderIds[rootP] = rootQ;
            groupSizes[rootQ] += groupSizes[rootP];
        } else {
            leaderIds[rootQ] = rootP;
            groupSizes[rootP] += groupSizes[rootQ];
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int n = f.nextInt();
            int m = f.nextInt();
            if(n == 0 && m == 0) {
                break;
            }
            int[] leaderIds = new int[n];
            int[] groupSizes = new int[n];
            for(int i = 0; i < n; i++) {
                leaderIds[i] = i;
                groupSizes[i] = 1;
            }
            for(int i = 0; i < m; i++) {
                int k = f.nextInt();
                int p = f.nextInt();
                for(int j = 1; j < k; j++) {
                    int q = f.nextInt();
                    if(root(leaderIds,p) != root(leaderIds,q)) {
                        union(leaderIds, groupSizes, p, q);
                    }
                }
            }
            out.println(groupSizes[root(leaderIds,0)]);
        }
        f.close();
        out.close();
    }
}