import org.junit.experimental.max.MaxHistory;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] placement = new int[M][2];
        for(int i = 0; i < M; i++){
            StringTokenizer favorites = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(favorites.nextToken());
            int b = Integer.parseInt(favorites.nextToken());
            placement[i] = new int[]{Math.min(a,b)-1,Math.max(a,b)-1};
        }
        /*
        Arrays.sort(placement, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return 0;
                }
                return o1[0] > o2[0] ? 1:-1;
            }
        });
         */
        int[] ans = new int[N];
        for(int i = 0; i < N; i++){
            int seed;
            for(seed = 1; seed <= 4; seed++){
                boolean valid = true;
                for(int j = 0; j < M; j++){
                    if(placement[j][1] == i && ans[placement[j][0]] == seed){
                        valid = false;
                        break;
                    }
                }
                if(valid){
                    break;
                }
            }
            ans[i] = seed;
            out.print(seed);
        }
        out.println();
        f.close();
        out.close();
    }
}
