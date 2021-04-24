import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        ArrayList<int[]> coins = new ArrayList<int[]>();
        int ans = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(f.readLine());
            int[] temp = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            if(temp[0] >= C) {
                ans += temp[1];
            } else {
                coins.add(temp);
            }
        }
        Collections.sort(coins, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return t1[0]-ints[0];
            }
        });
        while(true) {
            int[] need = new int[coins.size()];
            int left = C;
            for(int i = 0; i < coins.size(); i++) {
                need[i] = Math.min(coins.get(i)[1], left/coins.get(i)[0]);
                left -= need[i]*coins.get(i)[0];
            }
            if(left > 0) {
                for(int i = coins.size()-1; i >= 0; i--) {
                    if(coins.get(i)[1] > 0) {
                        need[i]++;
                        left = 0;
                        break;
                    }
                }
            }
            if(left > 0) {
                break;
            }
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < coins.size(); i++) {
                if(need[i] > 0) {
                    min = Math.min(min, coins.get(i)[1]/need[i]);
                }
            }
            ans += min;
            for(int i = 0; i < coins.size(); i++) {
                coins.get(i)[1] -= min*need[i];
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}