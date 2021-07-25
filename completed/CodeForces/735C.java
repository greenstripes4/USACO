import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long n = Long.parseLong(f.readLine());
        long a = 1;
        long b = 1;
        int rounds = 0;
        while(b <= n) {
            long temp = b;
            b += a;
            a = temp;
            rounds++;
        }
        out.println(rounds-1);
        f.close();
        out.close();
    }
}