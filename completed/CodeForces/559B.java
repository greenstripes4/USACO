import java.io.*;
import java.util.*;

public class Main {
    private static String smallest(String a) {
        if(a.length()%2 == 1) {
            return a;
        }
        String first = smallest(a.substring(0, a.length()/2));
        String second = smallest(a.substring(a.length()/2));
        if(first.compareTo(second) < 0) {
            return first+second;
        }
        return second+first;
    }
    private static boolean equal(String a, String b) {
        return smallest(a).equals(smallest(b));
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String a = f.readLine();
        String b = f.readLine();
        out.println(equal(a, b) ? "YES" : "NO");
        f.close();
        out.close();
    }
}