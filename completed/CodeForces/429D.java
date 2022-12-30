import java.io.*;
import java.util.*;

public class Main {
    private static long distance(int[] p1, int[] p2) {
        long distX = Math.abs(p1[0]-p2[0]);
        long distY = Math.abs(p1[1]-p2[1]);
        return distX*distX+distY*distY;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[][] points = new int[n][2];
        for(int i = 0; i < n; i++) {
            points[i][0] = i;
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i < n; i++) {
            points[i][1] += points[i-1][1];
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1]-b[1] : a[0]-b[0];
            }
        });
        TreeSet<int[]> relativePoints = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1]-b[1] : a[0]-b[0];
            }
        });
        int index = 0;
        long min = 1000000000;
        relativePoints.add(points[0]);
        for(int i = 1; i < n; i++) {
            while(index < i && points[i][0]-points[index][0] > min) {
                relativePoints.remove(points[index++]);
            }
            int[] first = relativePoints.higher(new int[]{points[i][0]-(int) min, -1});
            while(first != null) {
                long temp = distance(points[i], first);
                min = Math.min(min, temp);
                first = relativePoints.higher(first);
            }
            relativePoints.add(points[i]);
        }
        out.println(min);
        f.close();
        out.close();
    }
}