import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int q = Integer.parseInt(f.readLine());
        while(q-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            if(n < m) {
                long temp = n;
                n = m;
                m = temp;
            }
            long k = Long.parseLong(st.nextToken());
            if(n%2 != m%2) {
                n--;
                k--;
            } else if(n%2 != k%2) {
                n--;
                m--;
                k -= 2;
            }
            if(k < n || k < m) {
                out.println(-1);
            } else {
                out.println(k);
            }
        }
        f.close();
        out.close();
    }
}