import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        out.println(0);
        for(long k = 2; k <= n; k++) {
            long temp = (k*k*(k*k-1))/2;
            temp -= (k-1)*(k-2)*4;
            out.println(temp);
        }
        f.close();
        out.close();
    }
}