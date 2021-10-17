import java.io.*;
import java.util.*;

public class Main {
    private static boolean isValid(long[] a, long half) {
        HashSet<Long> seen = new HashSet<>();
        long cur = 0;
        boolean flag = false;
        for(int i = 0; i < a.length; i++) {
            if(cur == half || seen.contains(cur-half)) {
                flag = true;
                break;
            }
            cur += a[i];
            seen.add(a[i]);
        }
        if(cur == half || seen.contains(cur-half)) {
            flag = true;
        }
        return flag;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        long[] a = new long[n];
        long sum = 0;
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            sum += a[i];
        }
        if(sum%2 == 1) {
            out.println("NO");
        } else {
            if(isValid(a, sum/2)) {
                out.println("YES");
            } else {
                for(int i = 0; i < n/2; i++) {
                    long temp = a[i];
                    a[i] = a[n-i-1];
                    a[n-i-1] = temp;
                }
                if(isValid(a, sum/2)) {
                    out.println("YES");
                } else {
                    out.println("NO");
                }
            }
        }
        f.close();
        out.close();
    }
}
