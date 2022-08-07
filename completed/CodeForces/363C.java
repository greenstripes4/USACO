import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        ArrayList<Character> chars = new ArrayList<>();
        ArrayList<Integer> segments = new ArrayList<>();
        char[] s = f.readLine().toCharArray();
        int cnt = 0;
        for(int i = 0; i < s.length; i++) {
            if(i == 0 || s[i] == s[i-1]) {
                cnt++;
            } else {
                chars.add(s[i-1]);
                segments.add(Math.min(cnt, 2));
                cnt = 1;
            }
        }
        chars.add(s[s.length-1]);
        segments.add(Math.min(cnt, 2));
        for(int i = 1; i < segments.size(); i++) {
            if(segments.get(i) > 1 && segments.get(i-1) > 1) {
                segments.set(i, segments.get(i)-1);
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < chars.size(); i++) {
            res.append(String.valueOf(chars.get(i)).repeat(segments.get(i)));
        }
        out.println(res);
        f.close();
        out.close();
    }
}