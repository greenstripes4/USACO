import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int S = Integer.parseInt(f.readLine());
        while(S-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            double p = Double.parseDouble(st.nextToken());
            int I = Integer.parseInt(st.nextToken());
            if(p == 0) {
                out.println("0.0000");
                continue;
            }
            double a = Math.pow(1-p, I-1)*p;
            double r = Math.pow(1-p, N);
            out.printf("%.4f\n", a/(1-r));
        }
        f.close();
        out.close();
    }
}
