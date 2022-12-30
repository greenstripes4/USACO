import java.io.*;
import java.util.*;

public class Main {
    private static boolean isValid(ArrayList<Integer> arr, int tar) {
        int sum = 0;
        for(int i: arr) {
            sum += i;
        }
        if(sum%2 != tar%2) {
            return false;
        }
        int MAX = (sum+tar)/2;
        boolean[] dp = new boolean[MAX+1];
        dp[0] = true;
        for(int i: arr) {
            boolean[] next = new boolean[MAX+1];
            for(int j = i; j <= MAX; j++) {
                next[j] = dp[j] || dp[j-i];
            }
            dp = next;
        }
        return dp[MAX];
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] s = f.readLine().toCharArray();
        StringTokenizer st = new StringTokenizer(f.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        ArrayList<Integer> h = new ArrayList<>();
        ArrayList<Integer> v = new ArrayList<>();
        int cnt = 0;
        boolean first = true;
        boolean horizontal = true;
        for(char i: s) {
            if(i == 'T') {
                if(first) {
                    x -= cnt;
                    first = false;
                } else {
                    if(horizontal) {
                        h.add(cnt);
                    } else {
                        v.add(cnt);
                    }
                }
                cnt = 0;
                horizontal = !horizontal;
            } else {
                cnt++;
            }
        }
        if(first) {
            x -= cnt;
        } else {
            if(horizontal) {
                h.add(cnt);
            } else {
                v.add(cnt);
            }
        }
        out.println(isValid(h, Math.abs(x)) && isValid(v, Math.abs(y)) ? "Yes" : "No");
        f.close();
        out.close();
    }
}
