import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] s = f.readLine().toCharArray();
        int[][] occ = new int[2][2];
        long even = 0;
        long odd = 0;
        for(int i = 0; i < s.length; i++) {
            occ[s[i]-'a'][i%2]++;
            even += occ[s[i]-'a'][(i%2)^1];
            odd += occ[s[i]-'a'][i%2];
        }
        out.println(even + " " + odd);
        f.close();
        out.close();
    }
}