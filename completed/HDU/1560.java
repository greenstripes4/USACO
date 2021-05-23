import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static char[][] sequences;
    private static char[] chars = {'A', 'C', 'G', 'T'};
    private static boolean dfs(int cur, int max, int[] matched) {
        int maxLeft = 0;
        for(int i = 0; i < n; i++) {
            maxLeft = Math.max(maxLeft, sequences[i].length-matched[i]);
        }
        if(maxLeft == 0) {
            return true;
        }
        if(cur+maxLeft > max) {
            return false;
        }
        for(char i: chars) {
            int[] next = matched.clone();
            boolean flag = true;
            for(int j = 0; j < n; j++) {
                if(matched[j] == sequences[j].length) {
                    continue;
                }
                if(i == sequences[j][matched[j]]) {
                    flag = false;
                    next[j]++;
                }
            }
            if(!flag && dfs(cur+1, max, next)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = f.nextInt();
        while(t-- > 0) {
            n = f.nextInt();
            sequences = new char[n][];
            int max = 0;
            for(int i = 0; i < n; i++) {
                sequences[i] = f.next().toCharArray();
                max = Math.max(max, sequences[i].length);
            }
            while(!dfs(0, max, new int[n])) {
                max++;
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}