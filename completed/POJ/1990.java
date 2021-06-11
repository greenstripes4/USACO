import java.io.*;
import java.util.*;

public class Main {
    private static long[] BIT1;
    private static long[] BIT2;
    private static void update1(int index, int add) {
        while(index < BIT1.length) {
            BIT1[index] += add;
            index += index&-index;
        }
    }
    private static long query1(int index) {
        long sum = 0;
        while(index > 0) {
            sum += BIT1[index];
            index -= index&-index;
        }
        return sum;
    }
    private static void update2(int index, int add) {
        while(index < BIT2.length) {
            BIT2[index] += add;
            index += index&-index;
        }
    }
    private static long query2(int index) {
        long sum = 0;
        while(index > 0) {
            sum += BIT2[index];
            index -= index&-index;
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        int[][] cows = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cows, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0]-t1[0];
            }
        });
        BIT1 = new long[20001];
        BIT2 = new long[20001];
        long ans = 0;
        long sum = 0;
        for(int i = 0; i < N; i++) {
            long temp1 = query1(cows[i][1]);
            long temp2 = query2(cows[i][1]);
            ans += (temp2*cows[i][1]-temp1)*cows[i][0];
            ans += ((sum-temp1)-(i-temp2)*cows[i][1])*cows[i][0];
            update1(cows[i][1], cows[i][1]);
            update2(cows[i][1], 1);
            sum += cows[i][1];
        }
        out.println(ans);
        f.close();
        out.close();
    }
}