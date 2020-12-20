import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long low = 1;
        long high = ((long) n)*m;
        long ans = -1;
        while(low <= high) {
            long mid = (low+high)/2;
            long count = 0;
            for(int i = 1; i <= n; i++) {
                count += Math.min(m,  (mid-1)/i);
            }
            if(count < k) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
