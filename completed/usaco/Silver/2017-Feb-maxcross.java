import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("maxcross.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] broken = new int[N];
        for(int i = 0; i < B; i++) {
            broken[Integer.parseInt(f.readLine())-1] = 1;
        }
        int[] rangeSum = new int[N+1];
        for(int i = 1; i <= N; i++) {
            rangeSum[i] = rangeSum[i-1]+broken[i-1];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= N-K; i++) {
            min = Math.min(min,rangeSum[i+K]-rangeSum[i]);
        }
        out.println(min);
        f.close();
        out.close();
    }
}
