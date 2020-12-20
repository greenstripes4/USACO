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
        String input;
        while((input = f.readLine()) != null) {
            int n = Integer.parseInt(input);
            int total = 0;
            while(true) {
                int next = getSurvivor(n);
                if(next == n) {
                    total += 2*n;
                    break;
                }
                total += n-next;
                n = next;
            }
            out.println(total);
        }
        f.close();
        out.close();
    }
}
