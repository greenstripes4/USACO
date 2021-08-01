import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        if(n%2 == 0) {
            out.println(-1);
        } else {
            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = i;
            }
            int[] b = new int[n];
            for(int i = 0; i < n; i++) {
                b[i] = i;
            }
            int[] c = new int[n];
            for(int i = 0; i < n; i++) {
                c[i] = (a[i]+b[i])%n;
            }
            out.print(a[0]);
            for(int i = 1; i < n; i++) {
                out.print(" " + a[i]);
            }
            out.println();
            out.print(b[0]);
            for(int i = 1; i < n; i++) {
                out.print(" " + b[i]);
            }
            out.println();
            out.print(c[0]);
            for(int i = 1; i < n; i++) {
                out.print(" " + c[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}