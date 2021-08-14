import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int h = Integer.parseInt(st.nextToken());
        long n = Long.parseLong(st.nextToken());
        long nodes = 1L << h;
        boolean side = true;
        long ans = 0;
        while(h > 0) {
            if(side && n > (nodes >> 1)) {
                n -= nodes >> 1;
                ans += nodes;
            } else if(!side && n > (nodes >> 1)) {
                n -= nodes >> 1;
                ans++;
                side = true;
            } else if(!side) {
                ans += nodes;
            } else {
                ans++;
                side = false;
            }
            h--;
            nodes >>= 1;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}