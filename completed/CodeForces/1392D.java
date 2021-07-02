import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            char[] s = f.readLine().toCharArray();
            boolean same = true;
            for(char i: s) {
                if(i != s[0]) {
                    same = false;
                    break;
                }
            }
            if(same) {
                out.println((n+2)/3);
                continue;
            }
            ArrayList<Integer> segments = new ArrayList<>();
            int last = 0;
            for(int i = 0; i < n; i++) {
                if(s[i] != s[last]) {
                    segments.add(i-last);
                    last = i;
                }
            }
            if(s[n-1] == s[0]) {
                segments.set(0, segments.get(0)+n-last);
            } else {
                segments.add(n-last);
            }
            int ans = 0;
            for(int i: segments) {
                ans += i/3;
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}