import java.io.*;
import java.util.*;

public class Main {
    private static int solve(char[] s) {
        int total = 0;
        for(char i: s) {
            total += i == '0' ? 1 : 0;
        }
        int[] suff = new int[s.length+1];
        for(int i = s.length-1; i >= 0; i--) {
            suff[i] = suff[i+1]+(s[i] == '0' ? 1 : -1);
        }
        int min = Math.max(0, s.length-total-1);
        int max = 0;
        int cur = 0;
        for(int i = 0; i < s.length; i++) {
            min = Math.min(min, total-max-suff[i+1]);
            cur += s[i] == '0' ? 1 : -1;
            max = Math.max(max, cur);
        }
        return min;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            char[] s = f.readLine().toCharArray();
            StringBuilder[] arr = new StringBuilder[k];
            for(int i = 0; i < k; i++) {
                arr[i] = new StringBuilder();
            }
            int[] ones = new int[k];
            int total = 0;
            for(int i = 0; i < n; i++) {
                arr[i%k].append(s[i]);
                ones[i%k] += s[i]-'0';
                total += s[i]-'0';
            }
            int min = n;
            for(int i = 0; i < k; i++) {
                min = Math.min(min, solve(arr[i].toString().toCharArray())+total-ones[i]);
            }
            out.println(min);
        }
        f.close();
        out.close();
    }
}
