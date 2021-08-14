import java.io.*;
import java.util.*;

public class Main {
    private static void process(char[] s, boolean[] remove) {
        int idx = 0;
        int lastZero = -1;
        while(idx < s.length && (remove[idx] || s[idx] == '0')) {
            if(s[idx] == '0') {
                lastZero = idx;
            }
            remove[idx++] = true;
        }
        if(idx == s.length && lastZero >= 0) {
            remove[lastZero] = false;
        }
    }
    private static boolean[] compare(boolean[] a, boolean[] b) {
        int c1 = 0;
        for(boolean i: a) {
            if(i) {
                c1++;
            }
        }
        int c2 = 0;
        for(boolean i: b) {
            if(i) {
                c2++;
            }
        }
        return c1 < c2 ? a : b;
    }
    private static String build(char[] s, boolean[] remove) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length; i++) {
            if(!remove[i]) {
                res.append(s[i]);
            }
        }
        if(res.length() == 0) {
            res.append("-1");
        }
        return res.toString();
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] s = f.readLine().toCharArray();
        int sum = 0;
        for(char i: s) {
            sum += i-'0';
        }
        if(sum%3 == 0) {
            out.println(s);
        } else if(sum%3 == 1) {
            boolean[] remove1 = new boolean[s.length];
            boolean[] remove2 = new boolean[s.length];
            int left1 = 1;
            int left2 = 2;
            for(int i = s.length-1; i >= 0; i--) {
                if(left1 > 0 && (s[i]-'0')%3 == 1) {
                    remove1[i] = true;
                    left1--;
                } else if(left2 > 0 && (s[i]-'0')%3 == 2) {
                    remove2[i] = true;
                    left2--;
                }
            }
            if(left1 > 0 && left2 > 0) {
                out.println(-1);
            } else if(left1 > 0) {
                process(s, remove2);
                out.println(build(s, remove2));
            } else if(left2 > 0) {
                process(s, remove1);
                out.println(build(s, remove1));
            } else {
                process(s, remove1);
                process(s, remove2);
                out.println(build(s, compare(remove1, remove2)));
            }
        } else {
            boolean[] remove1 = new boolean[s.length];
            boolean[] remove2 = new boolean[s.length];
            int left1 = 2;
            int left2 = 1;
            for(int i = s.length-1; i >= 0; i--) {
                if(left1 > 0 && (s[i]-'0')%3 == 1) {
                    remove1[i] = true;
                    left1--;
                } else if(left2 > 0 && (s[i]-'0')%3 == 2) {
                    remove2[i] = true;
                    left2--;
                }
            }
            if(left1 > 0 && left2 > 0) {
                out.println(-1);
            } else if(left1 > 0) {
                process(s, remove2);
                out.println(build(s, remove2));
            } else if(left2 > 0) {
                process(s, remove1);
                out.println(build(s, remove1));
            } else {
                process(s, remove1);
                process(s, remove2);
                out.println(build(s, compare(remove1, remove2)));
            }
        }
        f.close();
        out.close();
    }
}