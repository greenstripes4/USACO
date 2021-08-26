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
        int min = n;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            min = Math.min(min, r-l+1);
        }
        out.println(min);
        out.print(0);
        for(int i = 1; i < n; i++) {
            out.print(" " + i%min);
        }
        out.println();
        f.close();
        out.close();
    }
}
