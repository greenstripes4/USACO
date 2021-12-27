import java.io.*;
import java.util.*;

public class Main {
    private static boolean helper(String x, String y) {
        if(x.length() > y.length()) {
            return false;
        }
        for(int i = 0; i <= y.length()-x.length(); i++) {
            if(y.startsWith(x, i) && !y.substring(0, i).contains("0") && !y.substring(i+x.length()).contains("0")) {
                return true;
            }
        }
        return false;
    }
    private static boolean isValid(String x, String y) {
        return helper(x, y) || helper(new StringBuilder(x).reverse().toString(), y);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        String x = Long.toBinaryString(Long.parseLong(st.nextToken()));
        String y = Long.toBinaryString(Long.parseLong(st.nextToken()));
        if(x.equals(y)) {
            out.println("YES");
        } else {
            String w = x.substring(0, x.lastIndexOf("1")+1);
            String z = x+"1";
            out.println(isValid(w, y) || isValid(z, y) ? "YES" : "NO");
        }
        f.close();
        out.close();
    }
}
