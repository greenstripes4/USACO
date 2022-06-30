import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        long dx = Math.abs(x1-x2);
        long dy = Math.abs(y1-y2);
        long dd = Math.abs(dx-dy);
        if(Math.min(dx, dy)*2 == Math.max(dx, dy)) {
            out.println(dd/3+dd%3);
        } else {
            out.println(dd/3+dd%3+1);
        }
        f.close();
        out.close();
    }
}