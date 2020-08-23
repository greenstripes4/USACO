import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int M = f.nextInt();
        for(int t = 0; t < M; t++) {
            if(t > 0) {
                out.println();
            }
            int N = f.nextInt();
            int K = f.nextInt();
            boolean[] notFalseCoin = new boolean[N+1];
            for(int i = 0; i < K; i++) {
                int Pi = f.nextInt();
                int[] coins = new int[Pi*2];
                for (int j = 0; j < Pi * 2; j++) {
                    coins[j] = f.nextInt();
                }
                if(f.next().equals("=")) {
                    for(int j: coins) {
                        notFalseCoin[j] = true;
                    }
                }
            }
            int ind = -1;
            int count = 0;
            for(int i = 1; i <= N; i++) {
                if(!notFalseCoin[i]) {
                    ind = i;
                    count++;
                }
            }
            if(count == 1) {
                out.println(ind);
            } else {
                out.println(0);
            }
        }
        f.close();
        out.close();
    }
}
