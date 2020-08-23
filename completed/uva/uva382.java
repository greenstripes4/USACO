import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        out.println("PERFECTION OUTPUT");
        while(true) {
            int N = f.nextInt();
            if(N == 0) {
                break;
            }
            int divisorSum = N > 1 ? 1 : 0;
            for(int i = 2; i*i <= N; i++) {
                if(N%i == 0) {
                    divisorSum += i+N/i;
                }
            }
            out.printf("%5d",N);
            if(divisorSum == N) {
                out.println("  PERFECT");
            } else if(divisorSum < N) {
                out.println("  DEFICIENT");
            } else {
                out.println("  ABUNDANT");
            }
        }
        out.println("END OF OUTPUT");
        f.close();
        out.close();
    }
}
