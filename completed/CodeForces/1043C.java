import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] s = f.readLine().toCharArray();
        int[] res = new int[s.length];
        for(int i = 1; i < s.length; i++) {
            if(s[i] == 'a') {
                res[i] = 1;
                res[i-1] ^= 1;
            }
        }
        out.print(res[0]);
        for(int i = 1; i < s.length; i++) {
            out.print(" " + res[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}