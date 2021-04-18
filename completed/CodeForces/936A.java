import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        long k = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());
        long t = Long.parseLong(st.nextToken())*2;
        long temp;
        if(k <= d) {
            temp = d;
        } else {
            temp = k/d*d;
            if(temp < k) {
                temp += d;
            }
        }
        long temp2 = k+temp;
        long temp3 = t/temp2;
        long temp4 = t-temp3*temp2;
        double temp5;
        if(temp4 <= k*2) {
            temp5 = temp4/2.0;
        } else {
            temp5 = temp4-k;
        }
        out.println(temp*temp3+temp5);
        f.close();
        out.close();
    }
}