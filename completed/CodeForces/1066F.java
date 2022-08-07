import java.io.*;
import java.util.*;

public class Main {
    private static long distance(int[] a, int[] b) {
        return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        TreeMap<Integer, int[][]> map = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int l = Math.max(x, y);
            map.putIfAbsent(l, new int[][]{{-1, 1000000001}, {1000000001, -1}});
            int[][] temp = map.get(l);
            if(x > temp[0][0] || x == temp[0][0] && y < temp[0][1]) {
                temp[0][0] = x;
                temp[0][1] = y;
            }
            if(x < temp[1][0] || x == temp[1][0] && y > temp[1][1]) {
                temp[1][0] = x;
                temp[1][1] = y;
            }
        }
        long[] dp = new long[2];
        int[] prev1 = {0, 0};
        int[] prev2 = {0, 0};
        for(int[][] i: map.values()) {
            long[] temp = new long[2];
            temp[0] = Math.min(dp[0]+distance(prev1, i[1]), dp[1]+distance(prev2, i[1]))+distance(i[0], i[1]);
            temp[1] = Math.min(dp[0]+distance(prev1, i[0]), dp[1]+distance(prev2, i[0]))+distance(i[0], i[1]);
            dp = temp;
            prev1 = i[0];
            prev2 = i[1];
        }
        out.println(Math.min(dp[0], dp[1]));
        f.close();
        out.close();
    }
}