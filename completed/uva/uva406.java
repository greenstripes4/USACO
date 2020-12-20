import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            boolean[] notPrime = new boolean[N+1];
            notPrime[0] = true;
            notPrime[1] = false;
            for(int i = 2; i <= N; i++) {
                if(!notPrime[i]) {
                    for(int j = i+i; j <= N; j += i) {
                        notPrime[j] = true;
                    }
                }
            }
            ArrayList<Integer> primes = new ArrayList<>();
            for(int i = 0; i <= N; i++) {
                if(!notPrime[i]) {
                    primes.add(i);
                }
            }
            out.print(input + ":");
            int start = primes.size()/2-C+(primes.size()%2 == 0 ? 0 : 1);
            int end = primes.size()/2+C;
            for(int i = Math.max(0, start); i < Math.min(primes.size(), end); i++) {
                out.print(" " + primes.get(i));
            }
            out.println("\n");
        }
        f.close();
        out.close();
    }
}
