import java.io.*;
import java.util.*;

public class Main {
    private static int W, H, x1, y1, x2, y2, w, h;
    private static int solve(int cx, int cy) {
        int x3, y3, x4, y4;
        if(cx == 0 && cy == 0) {
            x3 = 0;
            y3 = 0;
            x4 = w;
            y4 = h;
        } else if(cx == 0 && cy == H) {
            x3 = 0;
            y3 = cy-h;
            x4 = w;
            y4 = cy;
        } else if(cx == W && cy == 0) {
            x3 = cx-w;
            y3 = 0;
            x4 = cx;
            y4 = h;
        } else {
            x3 = cx-w;
            y3 = cy-h;
            x4 = cx;
            y4 = cy;
        }
        int c1 = x3-(x2-x1) < 0 ? Integer.MAX_VALUE : Math.max(0, x2-x3);
        int c2 = x4+(x2-x1) > W ? Integer.MAX_VALUE : Math.max(0, x4-x1);
        int c3 = y4+(y2-y1) > H ? Integer.MAX_VALUE : Math.max(0, y4-y1);
        int c4 = y3-(y2-y1) < 0 ? Integer.MAX_VALUE : Math.max(0, y2-y3);
        return Math.min(Math.min(c1, c2), Math.min(c3, c4));
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            int ans = Math.min(Math.min(solve(0, 0), solve(0, H)), Math.min(solve(W, 0), solve(W, H)));
            out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        }
        f.close();
        out.close();
    }
}