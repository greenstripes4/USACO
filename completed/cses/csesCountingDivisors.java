import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[] divisors = new int[1000001];
        for(int i = 1; i <= 1000000; i++) {
            for(int j = i; j <= 1000000; j += i) {
                divisors[j]++;
            }
        }
        int n = Integer.parseInt(f.readLine());
        for(int i = 0; i < n; i++) {
            out.println(divisors[Integer.parseInt(f.readLine())]);
        }
        f.close();
        out.close();
    }
}