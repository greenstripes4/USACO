import sun.awt.im.CompositionArea;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(f.readLine());
            boolean found = false;
            for(int a = 2; a*a <= n; a++) {
                if(n%a == 0) {
                    int nDividedByA = n/a;
                    for(int b = a+1; b*b <= nDividedByA; b++) {
                        if(nDividedByA%b == 0) {
                            int c = nDividedByA/b;
                            if(c != 1 && c != a && c != b) {
                                found = true;
                                out.println("YES");
                                out.println(a + " " + b + " " + c);
                                break;
                            }
                        }
                    }
                }
                if(found) {
                    break;
                }
            }
            if(!found) {
                out.println("NO");
            }
        }
        f.close();
        out.close();
    }
}
