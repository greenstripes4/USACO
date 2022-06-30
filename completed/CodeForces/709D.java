import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int x = -1;
        int y = -1;
        for(int i = 1; i < 45000; i++) {
            if(i*(i-1)/2 == a) {
                x = i;
            }
            if(i*(i-1)/2 == d) {
                y = i;
            }
        }
        if(x == -1 || y == -1) {
            out.println("Impossible");
        } else {
            if(x*y == b+c) {
                int w = c/x;
                int z = c%x;
                out.println("1".repeat(w)+"0".repeat(x-z)+"1".repeat(z > 0 ? 1 : 0)+"0".repeat(z)+"1".repeat(y-w-(z > 0 ? 1 : 0)));
            } else {
                if(b+c > 0) {
                    out.println("Impossible");
                } else if(x == 1) {
                    out.println("1".repeat(y));
                } else if(y == 1) {
                    out.println("0".repeat(x));
                } else {
                    out.println("Impossible");
                }
            }
        }
        f.close();
        out.close();
    }
}