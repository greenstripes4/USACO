import java.io.*;
import java.util.*;

public class Main {
    private static long min;
    private static long max;
    private static void getMinAndMax(int p, long number, int divisor) {
        if(p == 0) {
            if(number%divisor == 0) {
                min = Math.min(min,number);
                max = Math.max(max,number);
            }
            return;
        }
        getMinAndMax(p-1,number*10+1,divisor);
        getMinAndMax(p-1,number*10+2,divisor);
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int divisor = (int) Math.pow(2,q);
            min = Long.MAX_VALUE;
            max = Long.MIN_VALUE;
            getMinAndMax(p,0,divisor);
            if(min == Long.MAX_VALUE && max == Long.MIN_VALUE) {
                out.println("Case " + t + ": impossible");
            } else if(min == max) {
                out.println("Case " + t + ": " + min);
            } else {
                out.println("Case " + t + ": " + min + " " + max);
            }
        }
        f.close();
        out.close();
    }
}
