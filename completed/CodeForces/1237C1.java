import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[][] points = new int[n][3];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
            points[i][2] = Integer.parseInt(st.nextToken());
        }
        boolean[] removed = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(removed[i]) {
               continue;
            }
            removed[i] = true;
            int k = -1;
            int distance = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++) {
                if(removed[j]) {
                    continue;
                }
                int temp = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1])+Math.abs(points[i][2]-points[j][2]);
                if(temp < distance) {
                    k = j;
                    distance = temp;
                }
            }
            removed[k] = true;
            out.println((i+1) + " " + (k+1));
        }
        f.close();
        out.close();
    }
}
