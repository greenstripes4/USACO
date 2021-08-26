import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringBuilder sb = new StringBuilder();
        int cur = 1;
        while(n > 3) {
            for(int i = 0; i < (n+1)/2; i++) {
                sb.append(cur);
                sb.append(" ");
            }
            n /= 2;
            cur *= 2;
        }
        if(n == 1) {
            sb.append(1);
        } else if(n == 2) {
            sb.append(cur);
            sb.append(" ");
            sb.append(2*cur);
        } else {
            sb.append(cur);
            sb.append(" ");
            sb.append(cur);
            sb.append(" ");
            sb.append(3*cur);
        }
        out.println(sb);
        f.close();
        out.close();
    }
}