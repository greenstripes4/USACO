import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            char[] s = f.readLine().toCharArray();
            int diff = 0;
            int zeros = 0;
            for(int i: s) {
                if(i == '0') {
                    zeros++;
                }
            }
            for(int i = 0; i < n/2; i++) {
                if(s[i] != s[n-i-1]) {
                    diff++;
                }
            }

            if(s.length%2 == 1 && s[s.length/2] == '0') {
                if(diff == 0) {
                    out.println(zeros == 1 ? "BOB" : "ALICE");
                } else if(zeros == 2) {
                    out.println("DRAW");
                } else {
                    out.println("ALICE");
                }
            } else {
                if(diff == 0) {
                    out.println("BOB");
                } else {
                    out.println("ALICE");
                }
            }
        }
        f.close();
        out.close();
    }
}
