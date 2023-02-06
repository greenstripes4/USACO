import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("cowjump.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        int[][] points = new int[N][2];
        int[] x = new int[N];
        int[] y = new int[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
            x[i] = points[i][0];
            y[i] = points[i][1];
        }
        Arrays.sort(x);
        Arrays.sort(y);
        HashMap<Integer, Integer> xCompress = new HashMap<>();
        HashMap<Integer, Integer> yCompress = new HashMap<>();
        for(int i = 0; i < N; i++) {
            xCompress.put(x[i], i+1);
            yCompress.put(y[i], i+1);
        }
        int[][] prefSum = new int[N+1][N+1];
        for(int[] i: points) {
            i[0] = xCompress.get(i[0]);
            i[1] = yCompress.get(i[1]);
            prefSum[i[0]][i[1]]++;
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                prefSum[i][j] += prefSum[i-1][j];
                prefSum[i][j] += prefSum[i][j-1];
                prefSum[i][j] -= prefSum[i-1][j-1];
            }
        }
        long ans = 1;
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                int left = Math.min(points[i][0], points[j][0]);
                int right = Math.max(points[i][0], points[j][0]);
                int top = Math.max(points[i][1], points[j][1]);
                int bottom = Math.min(points[i][1], points[j][1]);
                long num1 = prefSum[right][bottom]-prefSum[left-1][bottom];
                long num2 = prefSum[right][N]-prefSum[left-1][N]-prefSum[right][top-1]+prefSum[left-1][top-1];
                ans += num1*num2;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
