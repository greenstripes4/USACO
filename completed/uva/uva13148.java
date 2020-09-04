import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0")) {
            int integer = Integer.parseInt(input);
            if(integer == 1 || integer == 64 || integer == 729 || integer == 4096 || integer == 15625 || integer == 46656 || integer == 117649 || integer == 262144 || integer == 531441 || integer == 1000000 || integer == 1771561 || integer == 2985984 || integer == 4826809 || integer == 7529536 || integer == 11390625 || integer == 16777216 || integer == 24137569 || integer == 34012224 || integer == 47045881 || integer == 64000000 || integer == 85766121) {
                out.println("Special");
            } else {
                out.println("Ordinary");
            }
        }
        f.close();
        out.close();
    }
}
