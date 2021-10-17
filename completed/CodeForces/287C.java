import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        if(n%4 == 0 || (n-1)%4 == 0) {
            int[] res = new int[n];
            for(int i = 0; i < n/2; i += 2) {
                res[i] = i+2;
                res[i+1] = n-i;
                res[n-i-1] = n-i-1;
                res[n-i-2] = i+1;
            }
            if(n%2 == 1) {
                res[n/2] = (n+1)/2;
            }
            out.print(res[0]);
            for(int i = 1; i < n; i++) {
                out.print(" " + res[i]);
            }
            out.println();
        } else {
            out.println(-1);
        }
        f.close();
        out.close();
    }
}
