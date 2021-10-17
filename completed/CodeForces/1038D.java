import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        long total = 0;
        int min = 1000000000;
        boolean neg = false;
        boolean pos = false;
        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            total += Math.abs(a);
            min = Math.min(min, Math.abs(a));
            if(a < 0) {
                neg = true;
            } else {
                pos = true;
            }
        }
        if(n == 1) {
            out.println(total*(neg ? -1 : 1));
        } else if(pos && neg) {
            out.println(total);
        } else {
            out.println(total-2*min);
        }
        f.close();
        out.close();
    }
}
