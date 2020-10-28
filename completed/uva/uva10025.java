import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++) {
            f.readLine();
            if(t > 0) {
                out.println();
            }
            int k = Math.abs(Integer.parseInt(f.readLine()));
            int sum = 0;
            int n = 1;
            while(true) {
                sum += n;
                if(sum >= k && (sum-k)%2 == 0) {
                    out.println(n);
                    break;
                }
                n++;
            }
        }
        f.close();
        out.close();
    }
}
