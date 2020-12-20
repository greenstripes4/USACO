import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            char[] s = f.readLine().toCharArray();
            int totalZeros = 0;
            int totalOnes = 0;
            for(char j: s) {
                if(j == '0') {
                    totalZeros++;
                } else {
                    totalOnes++;
                }
            }
            int zeros = 0;
            int ones = 0;
            int min = s.length;
            for(char j: s) {
                min = Math.min(min, Math.min(zeros, ones)+Math.min(totalZeros-zeros, totalOnes-ones));
                if(j == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            min = Math.min(min, Math.min(zeros, ones)+Math.min(totalZeros-zeros, totalOnes-ones));
            out.println(min);
        }
        f.close();
        out.close();
    }
}
