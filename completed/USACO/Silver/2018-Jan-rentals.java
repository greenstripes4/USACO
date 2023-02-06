import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("rental.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] c = new int[N];
        for(int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(f.readLine());
        }
        int[][] qp = new int[M][2];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(f.readLine());
            qp[i][0] = Integer.parseInt(st.nextToken());
            qp[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] r = new int[Q];
        for(int i = 0; i < Q; i++) {
            r[i] = Integer.parseInt(f.readLine());
        }
        Arrays.sort(c);
        Arrays.sort(qp, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[1]-t1[1];
            }
        });
        Arrays.sort(r);
        for(int i = 0; i < N/2; i++) {
            int temp = c[i];
            c[i] = c[N-i-1];
            c[N-i-1] = temp;
        }
        for(int i = 0; i < M/2; i++) {
            int[] temp = qp[i];
            qp[i] = qp[M-i-1];
            qp[M-i-1] = temp;
        }
        for(int i = 0; i < Q/2; i++) {
            int temp = r[i];
            r[i] = r[Q-i-1];
            r[Q-i-1] = temp;
        }
        long[] prefixSum = new long[Q+1];
        for(int i = 1; i <= Q; i++) {
            prefixSum[i] = prefixSum[i-1]+r[i-1];
        }
        long[] milkProfits = new long[N+1];
        long[] rentProfits = new long[N+1];
        rentProfits[0] = prefixSum[Math.min(Q,N)];
        int buyerIndex = 0;
        long maxProfit = 0;
        for(int i = 1; i <= N; i++) {
            milkProfits[i] = milkProfits[i-1];
            while(c[i-1] > 0 && buyerIndex < M) {
                milkProfits[i] += Math.min(c[i-1],qp[buyerIndex][0])*qp[buyerIndex][1];
                int temp = c[i-1];
                c[i-1] -= qp[buyerIndex][0];
                qp[buyerIndex][0] -= temp;
                if(qp[buyerIndex][0] <= 0) {
                    buyerIndex++;
                }
            }
            rentProfits[i] = prefixSum[Math.min(Q,N-i)];
            maxProfit = Math.max(maxProfit,milkProfits[i]+rentProfits[i]);
        }
        out.println(maxProfit);
        f.close();
        out.close();
    }
}
