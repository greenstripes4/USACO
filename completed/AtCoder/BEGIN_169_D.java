import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long N = Long.parseLong(f.readLine());
        long tempN = N;
        int count = 0;
        for(long i = 2; i*i < N; i++) {
            int exponent = 0;
            while(tempN%i == 0) {
                exponent++;
                tempN /= i;
            }
            int next = 1;
            while(exponent-next >= 0) {
                count++;
                exponent -= next++;
            }
        }
        if(tempN > 1) {
            count++;
        }
        out.println(count);
        f.close();
        out.close();
    }
}