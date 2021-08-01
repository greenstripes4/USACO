import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int max = 0;
        int min = 0;
        int[][] segments = new int[n][2];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            segments[i][0] = Integer.parseInt(st.nextToken());
            segments[i][1] = Integer.parseInt(st.nextToken());
            if(segments[i][0] > segments[max][0]) {
                max = i;
            }
            if(segments[i][1] < segments[min][1]) {
                min = i;
            }
        }
        int maxmax = 0;
        int maxmin = Integer.MAX_VALUE;
        int minmax = 0;
        int minmin = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(i != max) {
                maxmax = Math.max(maxmax, segments[i][0]);
                maxmin = Math.min(maxmin, segments[i][1]);
            }
            if(i != min) {
                minmax = Math.max(minmax, segments[i][0]);
                minmin = Math.min(minmin, segments[i][1]);
            }
        }
        maxmax = Math.min(maxmax, maxmin);
        minmax = Math.min(minmax, minmin);
        out.println(Math.max(maxmin-maxmax, minmin-minmax));
        f.close();
        out.close();
    }
}
