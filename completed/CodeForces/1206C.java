import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        if(n%2 == 0) {
            out.println("NO");
        } else {
            out.println("YES");
            int[] res = new int[2*n];
            int i = 1;
            int j = 2*n;
            for(int k = 0; k < n; k++) {
                if(k%2 == 0) {
                    res[k] = i++;
                    res[k+n] = i++;
                } else {
                    res[k] = j--;
                    res[k+n] = j--;
                }
            }
            out.print(res[0]);
            for(int k = 1; k < 2*n; k++) {
                out.print(" " + res[k]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
