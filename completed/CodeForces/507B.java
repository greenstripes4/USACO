import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        long r = Integer.parseInt(st.nextToken());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long xPrime = Integer.parseInt(st.nextToken());
        long yPrime = Integer.parseInt(st.nextToken());
        r = 4*r*r;
        long distance = (x-xPrime)*1L*(x-xPrime)+(y-yPrime)*1L*(y-yPrime);
        long low = 0;
        long high = 1000000;
        while(low < high) {
            long mid = (low+high)/2;
            BigInteger temp = BigInteger.valueOf(mid);
            temp = temp.multiply(temp);
            temp = temp.multiply(BigInteger.valueOf(r));
            int comp = temp.compareTo(BigInteger.valueOf(distance));
            if(comp >= 0) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        out.println(high);
        f.close();
        out.close();
    }
}
