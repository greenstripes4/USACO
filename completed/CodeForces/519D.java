import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] x = new int[26];
        for(int i = 0; i < 26; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }
        char[] s = f.readLine().toCharArray();
        HashMap<Long, int[]> map = new HashMap<>();
        long ans = 0;
        for(int i = 1; i < s.length; i++) {
            if(s[i] == s[i-1]) {
                ans++;
            }
        }
        long cur = 0;
        for(int i = 0; i < s.length; i++) {
            cur += x[s[i]-'a'];
            if(i < s.length-1 && map.containsKey(cur)) {
                ans += map.get(cur)[s[i+1]-'a'];
            }
            map.putIfAbsent(cur, new int[26]);
            map.get(cur)[s[i]-'a']++;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
