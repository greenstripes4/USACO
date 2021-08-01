import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String a = f.readLine().toLowerCase();
        String b = f.readLine().toLowerCase();
        int res = a.compareTo(b);
        out.println(res < 0 ? -1 : res > 0 ? 1 : 0);
        f.close();
        out.close();
    }
}