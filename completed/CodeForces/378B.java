import java.io.*;
import java.util.*;

public class Main {
    private static String build(boolean[] arr) {
        StringBuilder sb = new StringBuilder();
        for(boolean i: arr) {
            sb.append(i ? "1" : "0");
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[][] arr = new int[n][2];
        int[][] temp = new int[2*n][2];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            temp[2*i][0] = i;
            temp[2*i][1] = 0;
            temp[2*i+1][0] = i;
            temp[2*i+1][1] = 1;
        }
        Arrays.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return arr[ints[0]][ints[1]]-arr[t1[0]][t1[1]];
            }
        });
        boolean[][] res = new boolean[2][n];
        for(int i = 0; i < n; i++) {
            res[temp[i][1]][temp[i][0]] = true;
        }
        for(int i = 0; i < n/2; i++) {
            res[0][i] = true;
            res[1][i] = true;
        }
        out.println(build(res[0]));
        out.println(build(res[1]));
        f.close();
        out.close();
    }
}
