import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("cardgame.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cardgame.out")));
        int N = Integer.parseInt(f.readLine());
        boolean[] used = new boolean[2*N+1];
        int[] e = new int[N];
        for(int i = 0; i < N; i++) {
            e[i] = Integer.parseInt(f.readLine());
            used[e[i]] = true;
        }
        TreeSet<Integer> low = new TreeSet<>();
        TreeSet<Integer> high = new TreeSet<>();
        for(int i = 1; i <= 2*N; i++) {
            if(!used[i]) {
                if(low.size() == N/2) {
                    high.add(i);
                } else {
                    low.add(i);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < N/2; i++) {
            Integer temp = high.ceiling(e[i]);
            if(temp == null) {
                high.remove(high.first());
            } else {
                high.remove(temp);
                ans++;
            }
        }
        for(int i = N/2; i < N; i++) {
            Integer temp = low.floor(e[i]);
            if(temp == null) {
                low.remove(low.last());
            } else {
                low.remove(temp);
                ans++;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
