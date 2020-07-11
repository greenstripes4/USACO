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
    private static int union(int[] leaderIds, int[] groupSizes, int x, int y) {
        int rootX = root(leaderIds,x);
        int rootY = root(leaderIds,y);
        if(rootX == rootY) {
            return 1;
        }
        if(groupSizes[rootX] < groupSizes[rootY]) {
            leaderIds[rootX] = rootY;
            groupSizes[rootY] += groupSizes[rootX];
        } else {
            leaderIds[rootY] = rootX;
            groupSizes[rootX] += groupSizes[rootY];
        }
        return 0;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(f.hasNext()) {
            int[] leaderIds = new int[100001];
            int[] groupSizes = new int[100001];
            for(int i = 0; i < 100001; i++) {
                leaderIds[i] = i;
                groupSizes[i] = 1;
            }
            int refusals = 0;
            while(true) {
                int x = f.nextInt();
                if(x == -1) {
                    break;
                }
                int y = f.nextInt();
                refusals += union(leaderIds,groupSizes,x,y);
            }
            out.println(refusals);
        }
        f.close();
        out.close();
    }
}