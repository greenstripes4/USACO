import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int x1 = Integer.parseInt(st.nextToken())*2;
        int y1 = Integer.parseInt(st.nextToken())*2;
        int x2 = Integer.parseInt(st.nextToken())*2;
        int y2 = Integer.parseInt(st.nextToken())*2;
        st = new StringTokenizer(f.readLine());
        int x3 = Integer.parseInt(st.nextToken())*2;
        int y3 = Integer.parseInt(st.nextToken())*2;
        int x4 = Integer.parseInt(st.nextToken())*2;
        int y4 = Integer.parseInt(st.nextToken())*2;
        st = new StringTokenizer(f.readLine());
        int x5 = Integer.parseInt(st.nextToken())*2;
        int y5 = Integer.parseInt(st.nextToken())*2;
        int x6 = Integer.parseInt(st.nextToken())*2;
        int y6 = Integer.parseInt(st.nextToken())*2;
        boolean valid = false;
        for(int i = x1; i <= x2; i++) {
            if(i >= x3 && i <= x4 && y3 <= y1 && y4 >= y2) {
                continue;
            }
            if(i >= x5 && i <= x6 && y5 <= y1 && y6 >= y2) {
                continue;
            }
            if(i >= Math.max(x3, x5) && i <= Math.min(x4, x6) && Math.min(y4, y6) >= Math.max(y3, y5)) {
                if(Math.min(y3, y5) <= y1 && Math.max(y4, y6) >= y2) {
                    continue;
                }
            }
            valid = true;
            break;
        }
        out.println(valid ? "YES" : "NO");
        f.close();
        out.close();
    }
}