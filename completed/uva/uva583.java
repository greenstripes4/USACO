import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        boolean[] notPrime = new boolean[46341];
        notPrime[0] = true;
        notPrime[1] = true;
        for(int i = 2; i <= 46340; i++) {
            if(!notPrime[i]) {
                for(int j = i+i; j <= 46340; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 0; i <= 46340; i++) {
            if(!notPrime[i]) {
                primes.add(i);
            }
        }
        String input;
        while(!(input = f.readLine()).equals("0")) {
            int g = Integer.parseInt(input);
            out.print(g + " = ");
            if(g < 0) {
                out.print(-1 + " x ");
                g = -g;
            }
            boolean first = true;
            for(int i: primes) {
                if(i*i > g) {
                    break;
                }
                while(g%i == 0) {
                    if(!first) {
                        out.print(" x ");
                    }
                    out.print(i);
                    g /= i;
                    first = false;
                }
                if(g == 1) {
                    break;
                }
            }
            if(g > 1) {
                if(!first) {
                    out.print(" x ");
                }
                out.print(g);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
