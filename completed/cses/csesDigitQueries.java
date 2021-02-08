import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int q = Integer.parseInt(f.readLine());
        for(int i = 0; i < q; i++) {
            long k = Long.parseLong(f.readLine());
            int length = 1;
            long next = 9;
            long digits = 0;
            while(true) {
                digits += length*next;
                if(digits >= k) {
                    break;
                }
                length++;
                next *= 10;
            }
            digits -= length*next;
            k -= digits;
            long temp = (k-1)/length;
            k -= temp*length+1;
            long num = next/9+temp;
            out.println(Long.toString(num).charAt((int) k));
        }
        f.close();
        out.close();
    }
}