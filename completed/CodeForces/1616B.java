import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            char[] s = f.readLine().toCharArray();
            StringBuilder min = new StringBuilder();
            min.append(s[0]);
            for(int i = 1; i < n; i++) {
                if(s[i] > s[i-1]) {
                    break;
                }
                min.append(s[i]);
            }
            if(min.length() > 1 && min.charAt(1) == min.charAt(0)) {
                min = new StringBuilder(min.substring(0, 1));
            }
            String res = min.toString();
            res += min.reverse().toString();
            out.println(res);
        }
        f.close();
        out.close();
    }
}
