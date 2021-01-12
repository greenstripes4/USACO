import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            long n = Integer.parseInt(st.nextToken());
            long m = Integer.parseInt(st.nextToken());
            long total = (n*(n+1))/2;
            long first = (n-m)/(m+1);
            long temp = (m+1)*(first*(first+1))/2;
            out.println(total-temp-(first+1)*((n-m)%(m+1)));
        }
        f.close();
        out.close();
    }
}
