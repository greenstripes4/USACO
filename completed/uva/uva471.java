import java.io.*;
import java.util.*;

public class Main{
    private static boolean noRepeats(long x) {
        boolean[] seen = new boolean[10];
        while(x > 0) {
            if(seen[(int) (x%10)]) {
                return false;
            }
            seen[(int) (x%10)] = true;
            x /= 10;
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++) {
            if(t > 0){
                out.println();
            }
            f.readLine();
            long N = Long.parseLong(f.readLine());
            long limit = 9876543210L/N;
            for(long i = 1; i <= limit; i++) {
                if(noRepeats(i) && noRepeats(N*i)) {
                    out.println(N*i + " / " + i + " = " + N);
                }
            }
        }
        f.close();
        out.close();
    }
}
