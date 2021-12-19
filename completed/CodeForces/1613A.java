import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int cur = x1;
            int l1 = 0;
            while(cur > 0) {
                l1++;
                cur /= 10;
            }
            cur = x2;
            int l2 = 0;
            while(cur > 0) {
                l2++;
                cur /= 10;
            }
            if(l1+p1 == l2+p2) {
                for(int i = Math.min(l1, l2); i < Math.max(l1, l2); i++) {
                    if(l1 < l2) {
                        x1 *= 10;
                    } else {
                        x2 *= 10;
                    }
                }
                out.println(x1 == x2 ? "=" : x1 > x2 ? ">" : "<");
            } else {
                out.println(l1+p1 > l2+p2 ? ">" : "<");
            }
        }
        f.close();
        out.close();
    }
}
