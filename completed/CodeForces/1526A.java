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
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] a = new int[2*n];
            for(int i = 0; i < 2*n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);
            int[] b = new int[2*n];
            for(int i = 0; i < n; i++) {
                b[i*2] = a[i];
                b[i*2+1] = a[2*n-i-1];
            }
            out.print(b[0]);
            for(int i = 1; i < 2*n; i++) {
                out.print(" " + b[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
