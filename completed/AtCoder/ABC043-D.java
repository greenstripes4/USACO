import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException{
                //BufferedReader f = new BufferedReader(new FileReader("cowjump.in"));
                BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
                //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
                char[] s = f.readLine().toCharArray();
                if(s.length == 2) {
                        if(s[0] == s[1]) {
                                out.println("1 2");
                        } else {
                                out.println("-1 -1");
                        }
                } else {
                        boolean flag = false;
                        for(int i = 0; i < s.length-2; i++) {
                                if(s[i] == s[i+1] || s[i] == s[i+2] || s[i+1] == s[i+2]) {
                                        flag = true;
                                        out.println((i+1) + " " + (i+3));
                                        break;
                                }
                        }
                        if(!flag) {
                                out.println("-1 -1");
                        }
                }
                f.close();
                out.close();
    }
}
