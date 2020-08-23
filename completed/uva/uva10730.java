import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            String input = f.next();
            if(input.equals("0")) {
                break;
            }
            int n = Integer.parseInt(input.substring(0,input.length()-1));
            int[] sequence = new int[n];
            int[] numIndex = new int[n];
            for(int i = 0; i < n; i++) {
                sequence[i] = f.nextInt();
                numIndex[sequence[i]] = i;
            }
            boolean antiarithmetic = true;
            for(int i = 0; i < n; i++) {
                for(int j = i+1; j < n; j++) {
                    int thirdTerm = sequence[j]*2-sequence[i];
                    if(thirdTerm < 0 || thirdTerm >= n) {
                        continue;
                    }
                    if(numIndex[thirdTerm] > j) {
                        antiarithmetic = false;
                        break;
                    }
                }
                if(!antiarithmetic) {
                    break;
                }
            }
            out.println(antiarithmetic ? "yes" : "no");
        }
        f.close();
        out.close();
    }
}
