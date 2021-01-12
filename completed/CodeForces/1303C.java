import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            char[] s = f.readLine().toCharArray();
            boolean[] used = new boolean[26];
            StringBuilder sb = new StringBuilder();
            boolean valid = true;
            used[s[0]-'a'] = true;
            sb.append(s[0]);
            int index = 0;
            for(int i = 1; i < s.length; i++) {
                if(used[s[i]-'a']) {
                    if(index > 0 && sb.charAt(index-1) == s[i]) {
                        index--;
                    } else if(index+1 < sb.length() && sb.charAt(index+1) == s[i]) {
                        index++;
                    } else {
                        valid = false;
                        break;
                    }
                } else {
                    if(index == 0) {
                        sb.insert(0, s[i]);
                    } else if(index+1 == sb.length()) {
                        sb.append(s[i]);
                        index++;
                    } else {
                        valid = false;
                        break;
                    }
                    used[s[i]-'a'] = true;
                }
            }
            for(int i = 0; i < 26; i++) {
                if(!used[i]) {
                    sb.append((char) (i+'a'));
                }
            }
            out.println(valid ? "YES" : "NO");
            if(valid) {
                out.println(sb);
            }
        }
        f.close();
        out.close();
    }
}