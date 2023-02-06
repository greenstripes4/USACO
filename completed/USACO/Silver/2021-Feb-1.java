import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private static boolean[][] arr;
    private static int[][] dir;
    private static boolean hasCow(int x, int y) {
        if(x < 0 || x >= 1505 || y < 0 || y >= 1505) {
            return false;
        }
        return arr[x][y];
    }
    private static int add(int x, int y) {
        if(hasCow(x, y)) {
            return -1;
        }
        arr[x][y] = true;
        int ans = 0;
        int[] temp = getInvalid(x, y);
        if(temp != null) {
            ans += add(x+temp[0], y+temp[1])+1;
        }
        for(int[] i: dir) {
            int curX = x+i[0];
            int curY = y+i[1];
            temp = getInvalid(curX, curY);
            if(temp != null) {
                ans += add(curX+temp[0], curY+temp[1])+1;
            }
        }
        return ans;
    }
    private static int[] getInvalid(int x, int y) {
        if(!hasCow(x, y)) {
            return null;
        }
        int[] res = null;
        for(int[] i: dir) {
            if(!hasCow(x+i[0], y+i[1])) {
                if(res != null) {
                    return null;
                }
                res = i;
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        arr = new boolean[1505][1505];
        dir = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int N = Integer.parseInt(f.readLine());
        int ans = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken())+500;
            int y = Integer.parseInt(st.nextToken())+500;
            ans += add(x, y);
            out.println(ans);
        }
        f.close();
        out.close();
    }
}
