import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if(n == 1) {
            out.println(1);
        } else if(m == n) {
            out.println(m-1);
        } else if(m == 1) {
            out.println(m+1);
        } else if(m-1 >= n-m) {
            out.println(m-1);
        } else {
            out.println(m+1);
        }
        f.close();
        out.close();
    }
}
