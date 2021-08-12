import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        long p = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());
        long cur = 9;
        long div = 10;
        long ans = p;
        while(true) {
            long temp = (p-cur)/div*div+cur;
            if(temp < p-d || temp > p) {
                break;
            }
            ans = temp;
            cur = cur*10+9;
            div *= 10;
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
