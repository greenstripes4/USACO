import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        long[] a = new long[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        if(n == 1) {
            out.println("1 1");
            out.println(0);
            out.println("1 1");
            out.println(0);
            out.println("1 1");
            out.println(-a[0]);
        } else {
            out.println("1 1");
            out.println(-a[0]);
            out.println("1 " + n);
            out.print("0");
            for(int i = 1; i < n; i++) {
                out.print(" " + n*(-a[i]));
            }
            out.println();
            out.println("2 " + n);
            out.print((n-1)*a[1]);
            for(int i = 2; i < n; i++) {
                out.print(" " + (n-1)*a[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}