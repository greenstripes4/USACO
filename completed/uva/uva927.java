import java.io.*;
import java.util.*;

public class Main {
    private static int getN(int d, int k) {
        int numElements = 0;
        int n = 1;
        while(true) {
            if(k > numElements && k <= numElements+n*d) {
                return n;
            }
            numElements += n*d;
            n++;
        }
    }
    private static long valueOfAN(int n, int[] c) {
        long an = 0;
        long factor = 1;
        for(int i: c) {
            an += i*factor;
            factor *= n;
        }
        return an;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int C = Integer.parseInt(f.readLine());
        for(int t = 0; t < C; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int i = Integer.parseInt(st.nextToken());
            int[] c = new int[i+1];
            for(int j = 0; j <= i; j++) {
                c[j] = Integer.parseInt(st.nextToken());
            }
            int d = Integer.parseInt(f.readLine());
            int k = Integer.parseInt(f.readLine());
            int n = getN(d,k);
            out.println(valueOfAN(n,c));
        }
        f.close();
        out.close();
    }
}
