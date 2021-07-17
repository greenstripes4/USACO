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
    private static int bruteforce(char[] s) {
        int ans = 0;
        for(int i = 0; i < s.length; i++) {
            for(int j = i; j < s.length; j++) {
                int cur = 0;
                for(int k = i; k <= j; k++) {
                    cur = cur << 1 | (s[k] == '1' ? 1 : 0);
                    if(cur > j-i+1) {
                        cur = -1;
                        break;
                    }
                }
                if(cur == j-i+1) {
                    ans++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        int idx=10;
        while(idx <(1<<16)) {
            idx++;
            //char[] s = f.readLine().toCharArray();
            char[] s = String.format("%16s", Integer.toBinaryString(idx)).replace(' ', '0').toCharArray();
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
            if(ans == bruteforce(s)) {
                out.println("passed");
            } else {
                out.println("FAIL");
                out.println(s);
                break;
            }
        }
        f.close();
        out.close();
    }
}