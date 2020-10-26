import java.io.*;
import java.util.*;

public class Main{
    private static long f(long n) {
        if(n == 0) {
            return 0;
        }
        return f(n/2) + n%2;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            long n = Long.parseLong(f.readLine());
            out.println(f(n));
        }
        f.close();
        out.close();
    }
}
