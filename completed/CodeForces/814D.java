import java.io.*;
import java.util.*;

public class Main {
    private static long dist(int[] a, int[] b) {
        long dx = a[0]-b[0];
        long dy = a[1]-b[1];
        return dx*dx+dy*dy;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[][] circles = new int[n][3];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            circles[i][0] = Integer.parseInt(st.nextToken());
            circles[i][1] = Integer.parseInt(st.nextToken());
            circles[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(circles, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2]-o1[2];
            }
        });
        long[] area = new long[n];
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        boolean[] flag = new boolean[n];
        for(int i = 0; i < n; i++) {
            area[i] = ((long) circles[i][2])*circles[i][2];
            adjacencyList.add(new ArrayList<>());
            for(int j = i-1; j >= 0; j--) {
                if(dist(circles[i], circles[j]) <= area[j]) {
                    adjacencyList.get(j).add(i);
                    flag[i] = true;
                    break;
                }
            }
        }
        long[][][] dp = new long[n][2][2];
        for(int i = n-1; i >= 0; i--) {
            long[][] temp = new long[2][2];
            for(int j: adjacencyList.get(i)) {
                for(int k = 0; k < 2; k++) {
                    for(int l = 0; l < 2; l++) {
                        temp[k][l] += dp[j][k][l];
                    }
                }
            }
            for(int j = 0; j < 2; j++) {
                for(int k = 0; k < 2; k++) {
                    dp[i][j][k] = Math.max(temp[j^1][k]+(j == 0 ? area[i] : -area[i]), temp[j][k^1]+(k == 0 ? area[i] : -area[i]));
                }
            }
        }
        long ans = 0;
        for(int i = 0; i < n; i++) {
            if(!flag[i]) {
                ans += dp[i][0][0];
            }
        }
        out.println(ans*Math.PI);
        f.close();
        out.close();
    }
}