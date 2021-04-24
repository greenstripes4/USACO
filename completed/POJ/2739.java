import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        ArrayList<Integer> primes = new ArrayList<Integer>();
        boolean[] sieve = new boolean[10001];
        sieve[0] = true;
        sieve[1] = true;
        for(int i = 2; i <= 10000; i++) {
            if(!sieve[i]) {
                primes.add(i);
                for(int j = i+i; j <= 10000; j += i) {
                    sieve[j] = true;
                }
            }
        }
        String input;
        while(!(input = f.readLine()).equals("0")) {
            int n = Integer.parseInt(input);
            int ans = 0;
            int i = 0;
            int j = 0;
            int sum = 0;
            while(j <= primes.size()) {
                if(sum == n) {
                    ans++;
                    sum -= primes.get(i++);
                } else if(sum < n) {
                    if(j == primes.size()) {
                        break;
                    }
                    sum += primes.get(j++);
                } else {
                    sum -= primes.get(i++);
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}
