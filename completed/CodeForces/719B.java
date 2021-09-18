import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static char[] s;
    private static int solve(char start) {
        int i1 = 0;
        int i2 = 0;
        int ans = 0;
        for(char i: s) {
            if(i != start) {
                if(i == 'r') {
                    if(i2 > 0) {
                        i2--;
                        ans++;
                    } else {
                        i1++;
                    }
                } else {
                    if(i1 > 0) {
                        i1--;
                        ans++;
                    } else {
                        i2++;
                    }
                }
            }
            start = start == 'r' ? 'b' : 'r';
        }
        ans += i1;
        ans += i2;
        return ans;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        n = Integer.parseInt(f.readLine());
        s = f.readLine().toCharArray();
        out.println(Math.min(solve('r'), solve('b')));
        f.close();
        out.close();
    }
}