import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        char[] s = f.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        char LIS1 = 'a';
        char LIS2 = 'a';
        for(char i: s) {
            if(i >= LIS1) {
                sb.append(0);
                LIS1 = i;
            } else if(i >= LIS2) {
                sb.append(1);
                LIS2 = i;
            } else {
                out.println("NO");
                break;
            }
        }
        if(sb.length() == n) {
            out.println("YES");
            out.println(sb);
        }
        f.close();
        out.close();
    }
}