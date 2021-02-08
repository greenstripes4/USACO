import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            long d = Integer.parseInt(st.nextToken());
            long k = Integer.parseInt(st.nextToken());
            long z = 0;
            while(2*k*k*z*z <= d*d) {
                z++;
            }
            if(k*k*z*z+k*k*(z-1)*(z-1) <= d*d) {
                out.println("Ashish");
            } else {
                out.println("Utkarsh");
            }
        }
        f.close();
        out.close();
    }
}