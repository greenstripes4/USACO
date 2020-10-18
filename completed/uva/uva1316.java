import java.io.*;
import java.util.*;

public class Main{
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
            boolean[] taken = new boolean[10001];
            int maximumProfit = 0;
            for(int[] i: items) {
                int placement = i[1];
                while(placement > 0 && taken[placement]) {
                    placement--;
                }
                if(placement == 0) {
                    continue;
                }
                taken[placement] = true;
                maximumProfit += i[0];
            }
            out.println(maximumProfit);
        }
        f.close();
        out.close();
    }
}
