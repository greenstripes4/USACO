import java.io.*;
import java.util.*;

public class Main {
    private static boolean[][] reachable;
    private static boolean choose(int count, int idx, boolean[] covered) {
        if(count == 0) {
            return covered[0] && covered[1] && covered[2] && covered[3];
        }
        if(idx == reachable.length) {
            return false;
        }
        if(choose(count, idx+1, covered)) {
            return true;
        }
        boolean[] temp = covered.clone();
        for(int i = 0; i < 4; i++) {
            if(reachable[idx][i]) {
                temp[i] = true;
            }
        }
        return choose(count-1, idx+1, temp);
    }
    private static int distance(int x1, int y1, int x2, int y2) {
        int dx = x1-x2;
        int dy = y1-y2;
        return dx*dx+dy*dy;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int l = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] midpoints = {{-l, 0}, {l, 0}, {0, -w}, {0, w}};
        reachable = new boolean[n][4];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken())*2;
            int y = Integer.parseInt(st.nextToken())*2;
            for(int j = 0; j < 4; j++) {
                reachable[i][j] = distance(x, y, midpoints[j][0], midpoints[j][1]) <= 4*r*r;
            }
        }
        if(choose(1, 0, new boolean[4])) {
            out.println(1);
        } else if(choose(2, 0, new boolean[4])) {
            out.println(2);
        } else if(choose(3, 0, new boolean[4])) {
            out.println(3);
        } else if(choose(4, 0, new boolean[4])) {
            out.println(4);
        } else {
            out.println("Impossible");
        }
        f.close();
        out.close();
    }
}