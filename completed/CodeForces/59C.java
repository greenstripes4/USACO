import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int k = Integer.parseInt(f.readLine());
        char[] s = f.readLine().toCharArray();
        boolean[] used = new boolean[k];
        for(char i: s) {
            if(i != '?') {
                used[i-'a'] = true;
            }
        }
        char next = (char) ('a'+k-1);
        boolean flag = false;
        for(int i = (s.length-1)/2; i >= 0; i--) {
            if(s[i] != '?' && s[s.length-i-1] != '?') {
                if(s[i] != s[s.length-i-1]) {
                    flag = true;
                    break;
                }
            } else if(s[i] != '?') {
                s[s.length-i-1] = s[i];
            } else if(s[s.length-i-1] != '?') {
                s[i] = s[s.length-i-1];
            } else {
                while(next > 'a' && used[next-'a']) {
                    next--;
                }
                used[next-'a'] = true;
                s[i] = s[s.length-i-1] = next;
            }
        }
        while(next >= 'a' && used[next-'a']) {
            next--;
        }
        if(flag || next >= 'a') {
            out.println("IMPOSSIBLE");
        } else {
            out.println(s);
        }
        f.close();
        out.close();
    }
}