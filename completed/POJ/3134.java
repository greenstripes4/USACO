import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int[] a;
    private static int idx;
    private static boolean dfs(int d) {
        if(d < 0) {
            return false;
        }
        if(a[idx] << d < n) {
            return false;
        }
        if(a[idx] == n) {
            return true;
        }
        idx++;
        for(int i = 0; i < idx; i++) {
            a[idx] = a[idx-1]+a[i];
            if(dfs(d-1)) {
                return true;
            }
            a[idx] = Math.abs(a[idx-1]-a[i]);
            if(dfs(d-1)) {
                return true;
            }
        }
        idx--;
        return false;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            n = f.nextInt();
            if(n == 0) {
                break;
            }
            for(int i = 0; i < 15; i++) {
                a = new int[20];
                a[0] = 1;
                idx = 0;
                if(dfs(i)) {
                    out.println(i);
                    break;
                }
            }
        }
        f.close();
        out.close();
    }
}