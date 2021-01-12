import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int max1 = 0;
            double max2 = 0;
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(f.readLine());
                int di = Integer.parseInt(st.nextToken());
                int hi = Integer.parseInt(st.nextToken());
                max1 = Math.max(max1, di-hi);
                max2 = Math.max(max2, di);
            }
            if(max2 >= x) {
                out.println(1);
                continue;
            }
            if(max1 == 0) {
                out.println(-1);
                continue;
            }
            out.println((int) Math.ceil((x-max2)/max1)+1);
        }
        f.close();
        out.close();
    }
}