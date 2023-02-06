import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long N = Long.parseLong(f.readLine());
        HashSet<Long> res = new HashSet<>();
        for(long d = 1; d*d <= N-1; d++) {
            if((N-1)%d == 0) {
                res.add(d);
                res.add((N-1)/d);
            }
        }
        for(long d = 2; d*d <= N; d++) {
            if(N%d == 0) {
                long temp = N;
                while(temp%d == 0) {
                    temp /= d;
                }
                if(temp%d == 1) {
                    res.add(d);
                }
                temp = N;
                long d2 = N/d;
                while(temp%d2 == 0) {
                    temp /= d2;
                }
                if(temp%d2 == 1) {
                    res.add(d2);
                }
            }
        }
        out.println(res.size());
        f.close();
        out.close();
    }
}
