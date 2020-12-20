import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        boolean[] notPrime = new boolean[1000000];
        notPrime[0] = true;
        notPrime[1] = true;
        for(int i = 2; i < 1000000; i++) {
            if(!notPrime[i]) {
                for(int j = i+i; j < 1000000; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        String input;
        while(!(input = f.readLine()).equals("0")) {
            int n = Integer.parseInt(input);
            boolean found = false;
            for(int i = 0; i < n; i++) {
                if(!notPrime[i] && !notPrime[n-i]) {
                    found = true;
                    out.println(n + " = " + i + " + " + (n-i));
                    break;
                }
            }
            if(!found) {
                out.println("Goldbach's conjecture is wrong.");
            }
        }
        f.close();
        out.close();
    }
}
