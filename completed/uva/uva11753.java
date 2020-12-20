import java.io.*;
import java.util.*;
import java.io.*;
import java.util.*;

public class Main{
    private static int K;
    private static int solve(int[] sequence, int pointer1, int pointer2, int move) {
        if(move>K) return Integer.MAX_VALUE;
        if(pointer1 >= pointer2) {
            return move;
        }
        if(sequence[pointer1] == sequence[pointer2]) {
            return solve(sequence, pointer1+1, pointer2-1, move);
        } else {
            int D1 = solve(sequence, pointer1 + 1, pointer2, move+1);
            int D2 = solve(sequence, pointer1, pointer2 - 1, move+1);
            return Math.min(D1,D2);
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
            K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] sequence = new int[N];
            for(int i = 0; i < N; i++) {
                sequence[i] = Integer.parseInt(st.nextToken());
            }
            int D = solve(sequence, 0, N-1, 0);
            out.print("Case " + t + ": ");
            if(D == 0) {
                out.println("Too easy");
            } else if(D > K) {
                out.println("Too difficult");
            } else {
                out.println(D);
            }
        }
        f.close();
        out.close();
    }
}
/*
public class Main{
    private static int[][] memo;
    private static int solve(int[] sequence, int pointer1, int pointer2, int K) {
        if(pointer1 >= pointer2) {
            return 0;
        }
        if(memo[pointer1][pointer2] <=20) {
            return memo[pointer1][pointer2];
        }
        if(sequence[pointer1] == sequence[pointer2]) {
            int D = solve(sequence, pointer1+1, pointer2-1, K);
            memo[pointer1][pointer2] = D;
        } else {
            if(K>0) {
                int D1 = solve(sequence, pointer1 + 1, pointer2, K - 1);
                int D2 = solve(sequence, pointer1, pointer2 - 1, K - 1);
                memo[pointer1][pointer2] = Math.min(D1, D2) + 1;
            }
        }
        return memo[pointer1][pointer2];
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long start = System.nanoTime();
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int[] sequence = new int[N];
            for(int i = 0; i < N; i++) {
                sequence[i] = Integer.parseInt(st.nextToken());
            }
            memo = new int[N][N];
            for(int i = 0; i < N; i++) {
                Arrays.fill(memo[i], 100);
            }
            int D = solve(sequence, 0, N-1, K);
            out.print("Case " + t + ": ");
            if(D == 0) {
                out.println("Too easy");
            } else if(D > K) {
                out.println("Too difficult");
            } else {
                out.println(D);
            }
        }
        long end = System.nanoTime();
        long ms = ((end - start) / 1000000);
        out.println(ms);
        f.close();
        out.close();
    }
}
*/