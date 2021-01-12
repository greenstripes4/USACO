import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(f.readLine());
            long[][] monsters = new long[n][2];
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                monsters[i][0] = Long.parseLong(st.nextToken());
                monsters[i][1] = Long.parseLong(st.nextToken());
            }
            long total = 0;
            long min = Long.MAX_VALUE;
            for(int i = 0; i < n; i++) {
                int splashedBy = i-1 < 0 ? n-1 : i-1;
                total += Math.max(0, monsters[i][0]-monsters[splashedBy][1]);
                min = Math.min(min, Math.min(monsters[i][0], monsters[splashedBy][1]));
            }
            out.println(total+min);
        }
        f.close();
        out.close();
    }
}