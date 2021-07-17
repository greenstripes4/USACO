import java.io.*;
import java.util.*;

public class Main {
    private static int deleteLeftmostOne(int x) {
        int left = 18;
        while((x&(1 << left)) == 0) {
            left--;
        }
        return x&((1 << left)-1);
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            char[] s = f.readLine().toCharArray();
            int[] maxZeros = new int[s.length];
            for(int i = 1; i < s.length; i++) {
                maxZeros[i] = s[i-1] == '1' ? 0 : maxZeros[i-1]+1;
            }
            int ans = 0;
            for(int i = 1; i <= 18; i++) {
                int j = 0;
                while(j <= s.length-i && s[j] == '0') {
                    j++;
                }
                if(j > s.length-i) {
                    break;
                }
                int cur = 0;
                for(int k = j; k < j+i; k++) {
                    cur = cur << 1 | (s[k] == '1' ? 1 : 0);
                }
                while(s[j] == '1') {
                    if(cur >= i && cur <= i+maxZeros[j]) {
                        ans++;
                    }
                    if(j == s.length-i) {
                        break;
                    }
                    cur = deleteLeftmostOne(cur);
                    j++;
                    cur = cur << 1 | (s[j+i-1] == '1' ? 1 : 0);
                    while(j < s.length-i && s[j] == '0') {
                        j++;
                        cur = cur << 1 | (s[j+i-1] == '1' ? 1 : 0);
                    }
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}