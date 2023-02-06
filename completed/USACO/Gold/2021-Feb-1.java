import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] occ = new int[1000001];
        for(int i = 0; i < N; i++) {
            occ[Integer.parseInt(st.nextToken())]++;
        }
        for(int i = 1; i <= 1000000; i++) {
            occ[i] += occ[i-1];
        }
        long ans = 0;
        for(int i = 1; i <= 1000000; i++) {
            int odd = 0;
            int add = 0;
            int prev = 0;
            boolean adj = false;
            boolean first = false;
            for(int j = i; j <= 1000000; j += i) {
                int count = occ[Math.min(1000000, j+i-1)]-occ[Math.max(0, j-1)];
                if(count%2 == 1) {
                    odd++;
                    if(prev%2 == 1) {
                        add = count;
                        adj = true;
                    } else if(j == i) {
                        add = count;
                        first = true;
                    }
                }
                prev = count;
            }
            if(odd == 1 && first || odd == 2 && adj) {
                ans += add;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}