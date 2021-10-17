import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            long n = Long.parseLong(f.readLine());
            out.println((1-n) + " " + n);
        }
        f.close();
        out.close();
    }
}
