import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String s = f.readLine();
        String t1 = s.toUpperCase();
        String t2 = s.toLowerCase();
        int c1 = 0;
        int c2 = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == t1.charAt(i)) {
                c1++;
            } else {
                c2++;
            }
        }
        if(c1 > c2) {
            out.println(t1);
        } else {
            out.println(t2);
        }
        f.close();
        out.close();
    }
}