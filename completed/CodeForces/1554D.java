import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            if(n == 1) {
                out.println("a");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n/2; i++) {
                sb.append("a");
            }
            sb.append("b");
            if(n%2 == 1) {
                sb.append("c");
            }
            for(int i = 0; i < n/2-1; i++) {
                sb.append("a");
            }
            out.println(sb);
        }
        f.close();
        out.close();
    }
}
