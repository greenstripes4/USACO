import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        char[] s = f.readLine().toCharArray();
        char prev = ' ';
        int ans = 0;
        for(char i: s) {
            if(prev == ' ') {
                prev = i;
            } else {
                ans += i == prev ? 1 : 0;
                prev = i;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}