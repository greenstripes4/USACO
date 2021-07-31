import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] s = f.readLine().toCharArray();
        char cur = 'a';
        int ans = 0;
        for(char i: s) {
            int dist = Math.abs(i-cur);
            ans += Math.min(dist, 26-dist);
            cur = i;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}