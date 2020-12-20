import java.io.*;
import java.util.*;

public class Main{
    private static int getSurvivor(int n) {
        int result = 1;
        while(result <= n) {
            result = result << 1;
        }
        result = result >> 1;
        return 2*(n-result)+1;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 1; t <= testcases; t++) {
            int n = Integer.parseInt(f.readLine());
            int repetitions = 0;
            while(true) {
                int nextN = getSurvivor(n);
                if(nextN == n) {
                    break;
                }
                n = nextN;
                repetitions++;
            }
            out.println("Case " + t + ": " + repetitions + " " + n);
        }
        f.close();
        out.close();
    }
}
