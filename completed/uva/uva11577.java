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
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++) {
            char[] line = f.readLine().toLowerCase().toCharArray();
            int[] occurances = new int[26];
            for(char i: line) {
                if(Character.isAlphabetic(i)) {
                    occurances[i-'a']++;
                }
            }
            int max = 0;
            for(int i: occurances) {
                max = Math.max(max,i);
            }
            for(int i = 0; i < 26; i++) {
                if(occurances[i] == max) {
                    out.print((char)(i+'a'));
                }
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
