import java.io.*;
import java.util.*;

public class Main {
    private static boolean between(int x1, int x2, int x3) {
        return x3 > Math.min(x1, x2) && x3 < Math.max(x1, x2);
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        if((x1 == x2 && x2 == x3) || (y1 == y2 && y2 == y3)) {
            out.println(1);
        } else if((x1 == x2 && !between(y1, y2, y3)) || (x1 == x3 && !between(y1, y3, y2)) ||
                (x2 == x3 && !between(y2, y3, y1)) || (y1 == y2 && !between(x1, x2, x3)) ||
                (y1 == y3 && !between(x1, x3, x2)) || (y2 == y3 && !between(x2, x3, x1))) {
            out.println(2);
        } else {
            out.println(3);
        }
        f.close();
        out.close();
    }
}
