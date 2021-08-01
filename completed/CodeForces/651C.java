import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        HashMap<String, Integer> occ = new HashMap<>();
        HashMap<Integer, Integer> x = new HashMap<>();
        HashMap<Integer, Integer> y = new HashMap<>();
        long ans = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int xi = Integer.parseInt(st.nextToken());
            int yi = Integer.parseInt(st.nextToken());
            int sameX = x.getOrDefault(xi, 0);
            int sameY = y.getOrDefault(yi, 0);
            int samePoint = occ.getOrDefault(xi + " " + yi, 0);
            ans += sameX+sameY-samePoint;
            occ.put(xi + " " + yi, samePoint+1);
            x.put(xi, sameX+1);
            y.put(yi, sameY+1);
        }
        out.println(ans);
        f.close();
        out.close();
    }
}