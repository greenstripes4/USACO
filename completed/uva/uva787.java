import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(f.hasNext()) {
            ArrayList<BigInteger> sequence = new ArrayList<>();
            while(true) {
                int n = f.nextInt();
                if(n == -999999) {
                    break;
                }
                sequence.add(BigInteger.valueOf(n));
            }
            BigInteger max = sequence.get(0);
            for(int i = 0; i < sequence.size(); i++) {
                BigInteger temp = sequence.get(i);
                max = max.max(temp);
                for(int j = i+1; j < sequence.size(); j++) {
                    temp = temp.multiply(sequence.get(j));
                    max = max.max(temp);
                }
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}
