import java.io.*;
import java.util.*;

public class Main{
    private static class Pair implements Comparable<Pair>{
        private int X;
        private int Y;
        private Pair(int X) {
            this.X = X;
        }
        @Override
        public int compareTo(Pair o) {
            return o.Y-o.X-Y+X;
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            Pair[] pairs = new Pair[N];
            for(int i = 0; i < N; i++) {
                pairs[i] = new Pair(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(f.readLine());
            for(int i = 0; i < N; i++) {
                pairs[i].Y = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(pairs);
            long sum = 0;
            for(int i = 0; i < N-K; i++) {
                sum += pairs[i].Y-pairs[i].X;
            }
            for(int i = N-K; i < N; i++) {
                sum = Math.max(sum, sum+pairs[i].Y-pairs[i].X);
            }
            out.print("Case " + t + ": ");
            if(sum <= 0) {
                out.println("No Profit");
            } else {
                out.println(sum);
            }
        }
        f.close();
        out.close();
    }
}
