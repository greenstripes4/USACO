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
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] res = new int[k];
            for(int i = 0; i < k-3; i++) {
                res[i] = 1;
            }
            n -= k-3;
            if(n%2 == 1) {
                res[k-3] = 1;
                res[k-2] = n/2;
                res[k-1] = n/2;
            } else if(n%4 == 0) {
                res[k-3] = n/4;
                res[k-2] = n/4;
                res[k-1] = n/2;
            } else {
                res[k-3] = 2;
                res[k-2] = n/2-1;
                res[k-1] = n/2-1;
            }
            out.print(res[0]);
            for(int i = 1; i < k; i++) {
                out.print(" " + res[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}