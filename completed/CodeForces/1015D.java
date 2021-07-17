import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st  = new StringTokenizer(f.readLine());
        long n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long s = Long.parseLong(st.nextToken());
        if(k > s || k*(n-1) < s) {
            out.println("NO");
        } else {
            out.println("YES");
            long cur = 1;
            while(k > 0) {
                long steps = Math.min(n-1, s-k+1);
                cur = cur+steps > n ? cur-steps : cur+steps;
                out.print(cur + " ");
                s -= steps;
                k--;
            }
        }
        f.close();
        out.close();
    }
}