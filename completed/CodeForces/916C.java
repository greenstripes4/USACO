import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        out.println("100003 100003");
        for(int i = 1; i < n-1; i++) {
            out.println(i + " " + (i+1) + " 1");
        }
        out.println(n-1 + " " + n + " " + (100003-n+2));
        int left = m-n+1;
        for(int i = 1; i < n-1 && left > 0; i++) {
            for(int j = i+2; j <= n && left > 0; j++) {
                out.println(i + " " + j + " 1000000000");
                left--;
            }
        }
        f.close();
        out.close();
    }
}