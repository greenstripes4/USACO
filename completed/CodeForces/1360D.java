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
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int max = 1;
            for(int j = 1; j*j <= n; j++) {
                if(n%j == 0) {
                    if(j <= k) {
                        max = Math.max(max, j);
                    }
                    if(n/j <= k) {
                        max = Math.max(max, n/j);
                    }
                }
            }
            out.println(n/max);
        }
        f.close();
        out.close();
    }
}
