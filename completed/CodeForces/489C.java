import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        if(m == 1 && s == 0) {
            out.println("0 0");
        } else if(s == 0 || s > m*9) {
            out.println("-1 -1");
        } else {
            int x = s/9;
            int y = s%9;
            String max = "9".repeat(x);
            int left = m-x;
            if(y > 0) {
                max = max+y;
                left--;
            }
            max += "0".repeat(Math.max(0, left));
            StringBuilder min = new StringBuilder();
            int idx;
            for(idx = m-1; idx >= 0; idx--) {
                if(max.charAt(idx) > '0') {
                    break;
                }
            }
            if(idx < m-1) {
                min.append(1);
                min.append("0".repeat(Math.max(0, left-1)));
                min.append((char) (max.charAt(idx)-1));
                min.append("9".repeat(idx));
            } else {
                min.append(max.charAt(idx));
                min.append("9".repeat(m-1));
            }
            out.println(min + " " + max);
        }
        f.close();
        out.close();
    }
}