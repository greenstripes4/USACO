import java.io.*;
import java.util.*;

public class Main {
    private static long count;
    private static boolean isValid(int[][] cows, boolean[] used, int minX, int maxX, int minY, int maxY) {
        for(int i = 0; i < cows.length; i++) {
            if(cows[i][0] >= minX && cows[i][0] <= maxX && cows[i][1] >= minY && cows[i][1] <= maxY && !used[i]) {
                return false;
            }
        }
        return true;
    }
    private static void dfs(int[][] cows, boolean[] used, int minX, int maxX, int minY, int maxY, int index) {
        if(index == cows.length) {
            if(isValid(cows, used, minX, maxX, minY, maxY)) {
                count++;
            }
            return;
        }
        dfs(cows, used, minX, maxX, minY, maxY, index+1);
        int originalMinX = minX;
        int originalMaxX = maxX;
        int originalMinY = minY;
        int originalMaxY = maxY;
        used[index] = true;
        minX = Math.min(minX, cows[index][0]);
        maxX = Math.max(maxX, cows[index][0]);
        minY = Math.min(minY, cows[index][1]);
        maxY = Math.max(maxY, cows[index][1]);
        dfs(cows, used, minX, maxX, minY, maxY, index+1);
        used[index] = false;
        minX = originalMinX;
        maxX = originalMaxX;
        minY = originalMinY;
        maxY = originalMaxY;
    }
    public static void main(String[] args) throws IOException{
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
        count = 0;
        dfs(cows, new boolean[N], 1000000001, -1, 1000000001, -1, 0);
        out.println(count);
        f.close();
        out.close();
    }
}
