import java.io.*;
import java.util.*;

public class Main{
    private static int n;
    private static int[] sticks;
    private static boolean[] used;
    private static int tar;
    private static boolean dfs(int idx, int cur, int left) {
        if(left == 0) {
            return true;
        }
        if(cur == tar) {
            return dfs(0, 0, left-1);
        }
        if(tar-cur < sticks[n-1]) {
            return false;
        }
        int fail = -1;
        for(int i = idx; i < n; i++) {
            if(sticks[i] == tar) {
                used[i] = true;
                return dfs(i+1, cur, left-1);
            }
            if(!used[i] && sticks[i] != fail && cur+sticks[i] <= tar) {
                used[i] = true;
                if(dfs(i+1, cur+sticks[i], left)) {
                    return true;
                }
                fail = sticks[i];
                used[i] = false;
                if(cur == 0) {
                    return false;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            n = Integer.parseInt(f.readLine());
            if(n == 0) {
                break;
            }
            StringTokenizer st = new StringTokenizer(f.readLine());
            sticks = new int[n];
            int sum = 0;
            for(int i = 0; i < n; i++) {
                sticks[i] = Integer.parseInt(st.nextToken());
                sum += sticks[i];
            }
            Arrays.sort(sticks);
            for(int i = 0; i < n/2; i++) {
                int temp = sticks[i];
                sticks[i] = sticks[n-i-1];
                sticks[n-i-1] = temp;
            }
            for(int i = sticks[0]; i <= sum; i++) {
                if(sum%i == 0) {
                    used = new boolean[n];
                    tar = i;
                    if(dfs(0, 0, sum/i)) {
                        out.println(i);
                        break;
                    }
                }
            }
        }
        f.close();
        out.close();
    }
}
