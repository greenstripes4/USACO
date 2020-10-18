import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            f.readLine();
            char[] matches = f.readLine().toCharArray();
            int B = 0;
            int W = 0;
            int A = 0;
            for(char i: matches) {
                if(i == 'B') {
                    B++;
                } else if(i == 'W') {
                    W++;
                } else if(i == 'A') {
                    A++;
                }
            }
            if(A == matches.length) {
                out.println("Case " + t + ": ABANDONED");
            } else if(B == W) {
                out.println("Case " + t + ": DRAW " + B + " " + (matches.length-B-W-A));
            } else if(W == 0 && B+W+A == matches.length) {
                out.println("Case " + t + ": BANGLAWASH");
            } else if(B == 0 && B+W+A == matches.length) {
                out.println("Case " + t + ": WHITEWASH");
            } else if(B > W) {
                out.println("Case " + t + ": BANGLADESH " + B + " - " + W);
            } else {
                out.println("Case " + t + ": WWW " + W + " - " + B);
            }
        }
        f.close();
        out.close();
    }
}
