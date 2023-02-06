import java.io.*;
import java.util.*;

public class MainBruteforce {
    private static int ans;
    private static int check(char[] cur, char[] arr) {
        char[] temp = cur.clone();
        int prev = 0;
        for(int i = 0; i < cur.length-1; i++) {
            if(temp[i] == temp[i+1]) {
                int l = prev;
                int r = i;
                while(l < r) {
                    char c = temp[l];
                    temp[l] = temp[r];
                    temp[r] = c;
                    l++;
                    r--;
                }
                prev = i+1;
            }
        }
        int l = prev;
        int r = cur.length-1;
        while(l < r) {
            char c = temp[l];
            temp[l] = temp[r];
            temp[r] = c;
            l++;
            r--;
        }
        for(int i = 0; i < temp.length; i++) {
            if(arr[i] != '?' && arr[i] != temp[i]) {
                return 0;
            }
        }
        return 1;
    }
    private static void dfs(char[] cur, int idx, char[] arr) {
        if(idx == cur.length) {
            ans += check(cur, arr);
            return;
        }
        cur[idx] = 'A';
        dfs(cur, idx+1, arr);
        cur[idx] = 'C';
        dfs(cur, idx+1, arr);
        cur[idx] = 'G';
        dfs(cur, idx+1, arr);
        cur[idx] = 'T';
        dfs(cur, idx+1, arr);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] arr = f.readLine().toCharArray();
        ans = 0;
        dfs(new char[arr.length], 0, arr);
        out.println(ans);
        f.close();
        out.close();
    }
}