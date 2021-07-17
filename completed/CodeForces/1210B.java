import java.io.*;
import java.util.*;

public class Main {
    private static boolean canInclude(long[] a, long tar) {
        boolean found = false;
        for(long i: a) {
            if(i == tar) {
                if(found) {
                    return true;
                }
                found = true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        long[] a = new long[n];
        for(int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(f.readLine());
        int[] b = new int[n];
        for(int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] res = new boolean[n];
        long ans = 0;
        for(int i = 0; i < n; i++) {
            if(canInclude(a, a[i])) {
                res[i] = true;
                ans += b[i];
            }
        }
        for(int i = 0; i < n; i++) {
            if(!res[i]) {
                for(int j = 0; j < n; j++) {
                    if(res[j] && (a[j]&a[i]) == a[i]) {
                        res[i] = true;
                        ans += b[i];
                        break;
                    }
                }
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}