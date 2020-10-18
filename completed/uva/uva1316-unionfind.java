import java.io.*;
import java.util.*;

public class Main{
    private static int findRoot(int[] parentIds, int id) {
        while(parentIds[id] != id) {
            parentIds[id] = parentIds[parentIds[id]];
            id = parentIds[id];
        }
        return id;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(f.hasNext()) {
            int n = f.nextInt();
            int[][] items = new int[n][2];
            for(int i = 0; i < n; i++) {
                items[i][0] = f.nextInt();
                items[i][1] = f.nextInt();
            }
            Arrays.sort(items, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return t1[0]-ints[0];
                }
            });
            int[] parentIds = new int[10001];
            for(int i = 0; i < 10001; i++) {
                parentIds[i] = i;
            }
            boolean[] taken = new boolean[10001];
            taken[0] = true;
            int total = 0;
            for(int[] i: items) {
                int root = findRoot(parentIds, i[1]);
                if(!taken[root]) {
                    taken[root] = true;
                    total += i[0];
                    parentIds[root] = root > 0 ? parentIds[root-1] : 0;
                }
            }
            out.println(total);
        }
        f.close();
        out.close();
    }
}
