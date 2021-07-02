import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        if(m >= n) {
            out.println(n);
        } else {
            long low = 1;
            long high = Math.min(n, 2000000007);
            long ans = 0;
            while(low <= high) {
                long mid = (low+high)/2;
                if(mid*(mid-1)/2+mid+m >= n) {
                    high = mid-1;
                    ans = mid;
                } else {
                    low = mid+1;
                }
            }
            out.println(ans+m);
        }
        f.close();
        out.close();
    }
}