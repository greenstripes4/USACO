import java.io.*;
import java.util.*;

public class Main {
    private static int[] intersect(int[] a, int[] b) {
        int[] res = {Math.max(a[0], b[0]), Math.min(a[1], b[1])};
        if(res[0] >= res[1]) {
            return null;
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int n = Integer.parseInt(f.readLine());
            if(n == 0) {
                break;
            }
            int[][][] cubes = new int[n][3][2];
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                cubes[i][0][0] = x;
                cubes[i][0][1] = x+s;
                cubes[i][1][0] = y;
                cubes[i][1][1] = y+s;
                cubes[i][2][0] = z;
                cubes[i][2][1] = z+s;
            }
            int[][] res = new int[3][];
            res[0] = intersect(cubes[0][0], cubes[1][0]);
            res[1] = intersect(cubes[0][1], cubes[1][1]);
            res[2] = intersect(cubes[0][2], cubes[1][2]);
            for(int i = 2; i < n && res[0] != null && res[1] != null && res[2] != null; i++) {
                res[0] = intersect(res[0], cubes[i][0]);
                res[1] = intersect(res[1], cubes[i][1]);
                res[2] = intersect(res[2], cubes[i][2]);
            }
            if(res[0] == null || res[1] == null || res[2] == null) {
                out.println(0);
            } else {
                out.println((res[0][1]-res[0][0])*(res[1][1]-res[1][0])*(res[2][1]-res[2][0]));
            }
        }
        f.close();
        out.close();
    }
}