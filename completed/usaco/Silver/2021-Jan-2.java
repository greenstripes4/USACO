import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("cowjump.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        char[] s = f.readLine().toCharArray();
        int[] min = new int[26];
        Arrays.fill(min, 26);
        int[] pref = new int[N+2];
        for(int i = 1; i <= N; i++) {
            pref[i] = pref[i-1];
            int val = s[i-1]-'A';
            if(min[val] != val) {
                pref[i]++;
            }
            for(int j = 0; j < 26; j++) {
                min[j] = Math.min(min[j], val);
            }
            min[val] = val;
        }
        Arrays.fill(min, 26);
        int[] suff = new int[N+2];
        for(int i = N; i > 0; i--) {
            suff[i] = suff[i+1];
            int val = s[i-1]-'A';
            if(min[val] != val) {
                suff[i]++;
            }
            for(int j = 0; j < 26; j++) {
                min[j] = Math.min(min[j], val);
            }
            min[val] = val;
        }
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            out.println(pref[a-1]+suff[b+1]);
        }
        f.close();
        out.close();
    }
}
