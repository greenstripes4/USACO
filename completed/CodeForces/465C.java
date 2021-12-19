import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("cowjump.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        char p = (char) ('a'+Integer.parseInt(st.nextToken())-1);
        char[] s = f.readLine().toCharArray();
        int i;
        for(i = n-1; i >= 0; i--) {
            char l = i-1 >= 0 ? s[i-1] : '0';
            char ll = i-2 >= 0 ? s[i-2] : '0';
            char next = (char) (s[i]+1);
            while(next <= p && (next == l || next == ll)) {
                next++;
            }
            if(next <= p) {
                s[i] = next;
                break;
            }
        }
        if(i < 0) {
            out.println("NO");
        } else {
            for(int j = i+1; j < n; j++) {
                char l = j-1 >= 0 ? s[j-1] : '0';
                char ll = j-2 >= 0 ? s[j-2] : '0';
                char next = 'a';
                while(next == l || next == ll) {
                    next++;
                }
                s[j] = next;
            }
            out.println(s);
        }
        f.close();
        out.close();
    }
}
