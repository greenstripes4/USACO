import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("berries.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] B = new int[N];
        int M = 0;
        for(int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
            M = Math.max(M, B[i]);
        }
        int max = 0;
        for(int tar = 1; tar <= M; tar++) {
            int baskets = 0;
            ArrayList<Integer> extras = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                baskets += B[i]/tar;
                extras.add(B[i]%tar);
            }
            if(baskets < K/2) {
                break;
            }
            if(baskets >= K) {
                max = Math.max(max, K/2*tar);
            } else {
                int sum = (baskets-K/2)*tar;
                Collections.sort(extras);
                for(int i = N-K+baskets; i < N; i++) {
                    sum += extras.get(i);
                }
                max = Math.max(max, sum);
            }
        }
        out.println(max);
        f.close();
        out.close();
    }
}
