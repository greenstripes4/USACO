import java.io.*;
import java.util.*;

public class Main {
    private static final int MOD = 1000000007;
    private static int add(long a, long b) { return (int) (((a+MOD)%MOD+(b+MOD)%MOD)%MOD); }
    private static int solve(ArrayList<Character> arr1, ArrayList<Character> arr2) {
        int[][][] dp = new int[arr1.size()+1][arr2.size()+1][2];
        for(int i = 0; i <= arr2.size(); i++) {
            dp[0][i][0] = dp[0][i][1] = 1;
        }
        for(int i = 1; i <= arr1.size(); i++) {
            dp[i][0][0] = dp[i][0][1] = 1;
        }
        for(int i = 1; i <= arr1.size(); i++) {
            for(int j = 1; j <= arr2.size(); j++) {
                char a = arr1.get(i-1);
                char b = arr2.get(j-1);
                dp[i][j][0] = add(dp[i-1][j][0], dp[i-1][j][1]);
                if(a != b) {
                    dp[i][j][1] = add(dp[i][j-1][0], dp[i][j-1][1]);
                }
            }
        }
        return add(dp[arr1.size()][arr2.size()][0], dp[arr1.size()][arr2.size()][1]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        while(T-- > 0) {
            f.readLine();
            char[] a = f.readLine().toCharArray();
            char[] b = f.readLine().toCharArray();
            ArrayList<Character> arr1 = new ArrayList<>();
            for(char i: a) {
                if(i == '0') {
                    arr1.clear();
                } else if(i != '1') {
                    if(i == '+') {
                        arr1.add('+');
                    } else {
                        arr1.add('*');
                    }
                }
            }
            ArrayList<Character> arr2 = new ArrayList<>();
            for(char i: b) {
                if(i == '0') {
                    arr2.clear();
                } else if(i != '1') {
                    if(i == '+') {
                        arr2.add('+');
                    } else {
                        arr2.add('*');
                    }
                }
            }
            out.println(solve(arr1, arr2));
        }
        f.close();
        out.close();
    }
}
