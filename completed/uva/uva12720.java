import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            char[] s = f.readLine().toCharArray();
            int i = (s.length-1)/2;
            int j = s.length/2;
            int ans = 0;
            boolean left = true;
            for(int k = 0; k < s.length; k++) {
                if(k%2 == s.length%2) {
                    ans = ((ans << 1) | Math.max(s[i]-'0', s[j]-'0'))%1000000007;
                    if(s[i]-'0' >= s[j]-'0') {
                        left = true;
                        i += k+1;
                    } else {
                        left = false;
                        j -= k+1;
                    }
                } else {
                    ans = ((ans << 1) | (s[i]-'0'))%1000000007;
                    if(left) {
                        i -= k+1;
                        j++;
                    } else {
                        i--;
                        j += k+1;
                    }
                }
            }
            out.println("Case #" + t +": " + ans);
        }
        f.close();
        out.close();
    }
}