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
            int C = f.nextInt();
            int R = f.nextInt();
            if(C == 0 && R == 0) {
                break;
            }
            HashMap<String,Integer> getIndex = new HashMap<>();
            for(int i = 0; i < C; i++) {
                getIndex.put(f.next(),i);
            }
            int[] leaderIds = new int[C];
            int[] groupSizes = new int[C];
            for(int i = 0; i < C; i++) {
                leaderIds[i] = i;
                groupSizes[i] = 1;
            }
            for(int i = 0; i < R; i++) {
                int p = getIndex.get(f.next());
                int q = getIndex.get(f.next());
                if(root(leaderIds,p) != root(leaderIds,q)) {
                    union(leaderIds,groupSizes,p,q);
                }
            }
            int max = 0;
            for(int i = 0; i < C; i++) {
                int p = root(leaderIds,i);
                max = Math.max(max,groupSizes[p]);
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}