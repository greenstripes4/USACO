import java.io.*;
import java.util.*;

public class Main {
    private static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = f.nextInt();
        ArrayList<Integer> coprime = new ArrayList<>();
        long p = 1;
        for(int i = 1; i < n; i++) {
            if(gcd(i, n) == 1) {
                coprime.add(i);
                p = (p*i)%n;
            }
        }
        if(p != 1) {
            coprime.remove(coprime.indexOf((int) p));
        }
        out.println(coprime.size());
        out.print(coprime.get(0));
        for(int i = 1; i < coprime.size(); i++) {
            out.print(" " + coprime.get(i));
        }
        out.println();
        f.close();
        out.close();
    }
}
