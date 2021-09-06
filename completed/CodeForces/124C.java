import java.io.*;
import java.util.*;

public class Main {
    private static boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }
        for(int i = 2; i*i <= n; i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] s = f.readLine().toCharArray();
        boolean[] free = new boolean[s.length];
        free[0] = true;
        for(int i = s.length/2; i < s.length; i++) {
            if(isPrime(i+1)) {
                free[i] = true;
            }
        }
        int[] occ = new int[26];
        for(char i: s) {
            occ[i-'a']++;
        }
        int max = 0;
        for(int i = 1; i < 26; i++) {
            if(occ[i] > occ[max]) {
                max = i;
            }
        }
        char[] res = new char[s.length];
        boolean flag = false;
        for(int i = 0; i < s.length; i++) {
            if(!free[i]) {
                if(occ[max] == 0) {
                    flag = true;
                    break;
                } else {
                    res[i] = (char) ('a'+max);
                    occ[max]--;
                }
            }
        }
        if(flag) {
            out.println("NO");
        } else {
            out.println("YES");
            for(int i = 0; i < s.length; i++) {
                if(free[i]) {
                    for(int j = 0; j < 26; j++) {
                        if(occ[j] > 0) {
                            res[i] = (char) ('a'+j);
                            occ[j]--;
                            break;
                        }
                    }
                }
            }
            out.println(res);
        }
        f.close();
        out.close();
    }
}