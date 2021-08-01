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
            if(n <= 6) {
                out.println(15);
            } else if(n <= 8) {
                out.println(20);
            } else  if(n <= 10) {
                out.println(25);
            } else {
                out.println((n+1)/2*5);
            }
        }
        f.close();
        out.close();
    }
}