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
        int N = Integer.parseInt(f.readLine());
        for(int t = 0; t < N; t++) {
            int[] occurances = new int[26];
            char[] ingredients = f.readLine().toCharArray();
            for(char i: ingredients) {
                occurances[i-'A']++;
            }
            out.println(Math.min(occurances[0]/3,Math.min(occurances[6],Math.min(occurances[8],Math.min(occurances[12],Math.min(occurances[17]/2,occurances[19]))))));
        }
        f.close();
        out.close();
    }
}
