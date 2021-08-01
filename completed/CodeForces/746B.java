import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        char[] s = f.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char i: s) {
            if(n%2 == 0) {
                sb.insert(0, i);
            } else {
                sb.append(i);
            }
            n--;
        }
        out.println(sb);
        f.close();
        out.close();
    }
}