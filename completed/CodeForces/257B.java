import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] left = {n-1, m};
        int[] points1 = new int[2];
        int last = 0;
        for(int i = 1; i < n+m; i++) {
            if(i%2 == 0) {
                if(left[last] > 0) {
                    points1[0]++;
                    left[last]--;
                } else {
                    points1[1]++;
                    last = (last+1)%2;
                    left[last]--;
                }
            } else {
                if(left[(last+1)%2] > 0) {
                    points1[1]++;
                    last = (last+1)%2;
                    left[last]--;
                } else {
                    points1[0]++;
                    left[last]--;
                }
            }
        }
        left = new int[]{n, m-1};
        int[] points2 = new int[2];
        last = 1;
        for(int i = 1; i < n+m; i++) {
            if(i%2 == 0) {
                if(left[last] > 0) {
                    points2[0]++;
                    left[last]--;
                } else {
                    points2[1]++;
                    last = (last+1)%2;
                    left[last]--;
                }
            } else {
                if(left[(last+1)%2] > 0) {
                    points2[1]++;
                    last = (last+1)%2;
                    left[last]--;
                } else {
                    points2[0]++;
                    left[last]--;
                }
            }
        }
        if(points1[0] > points2[0] || (points1[0] == points2[0] && points1[1] < points2[1])) {
            out.println(points1[0] + " " + points1[1]);
        } else {
            out.println(points2[0] + " " + points2[1]);
        }
        f.close();
        out.close();
    }
}
