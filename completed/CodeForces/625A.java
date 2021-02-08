import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long n = Long.parseLong(f.readLine());
        long a = Long.parseLong(f.readLine());
        long b = Long.parseLong(f.readLine());
        long c = Long.parseLong(f.readLine());
        if(b > n || b-c >= a) {
            out.println(n/a);
        } else {
            long temp = (n-c)/(b-c);
            out.println(temp+(n-(b-c)*temp)/a);
        }
        f.close();
        out.close();
    }
}
