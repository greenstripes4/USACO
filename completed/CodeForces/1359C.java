import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            long h = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());
            long t = Integer.parseInt(st.nextToken());
            if(h+c >= 2*t) {
                out.println(2);
            } else {
                long k = (t-h)/(h+c-2*t);
                if(Math.abs((k+1)*h+k*c-(2*k+1)*t)*(2*k+3) > Math.abs((k+2)*h+(k+1)*c-(2*k+3)*t)*(2*k+1)) {
                    out.println(2*k+3);
                } else {
                    out.println(2*k+1);
                }
            }
        }
        f.close();
        out.close();
    }
}
