import java.io.*;
import java.util.*;

public class Main {
    private static boolean isCube(long x) {
        long low = 0;
        long high = 1000000;
        while(low <= high) {
            long mid = (low+high)/2;
            long cube = mid*mid*mid;
            if(cube == x) {
                return true;
            }
            if(cube < x) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            out.println(isCube(a*a/b) && isCube(b*b/a) ? "YES" : "NO");
        }
        f.close();
        out.close();
    }
}
