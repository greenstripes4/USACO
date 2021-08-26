import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] s = f.readLine().toCharArray();
        char min = 'z';
        for(char i: s) {
            if(min < i) {
                out.println("Ann");
            } else {
                out.println("Mike");
                min = i;
            }
        }
        f.close();
        out.close();
    }
}
