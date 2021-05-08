import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            long A = Integer.parseInt(st.nextToken());
            long B = Integer.parseInt(st.nextToken());
            if(B == 1) {
                out.println("NO");
            } else {
                out.println("YES");
                out.println(A + " " + A*B + " " + A*(B+1));
            }
        }
        f.close();
        out.close();
    }
}
