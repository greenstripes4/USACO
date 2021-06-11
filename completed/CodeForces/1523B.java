import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            f.readLine();
            out.println(3*n);
            for(int i = 1; i <= n; i += 2) {
                String type1 = "1 " + i + " " + (i+1);
                String type2 = "2 " + i + " " + (i+1);
                out.println(type1);
                out.println(type2);
                out.println(type1);
                out.println(type1);
                out.println(type2);
                out.println(type1);
            }
        }
        f.close();
        out.close();
    }
}