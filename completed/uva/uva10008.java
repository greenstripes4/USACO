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
        int n = Integer.parseInt(f.readLine());
        int[] occurances = new int[26];
        for(int t = 0; t < n; t++) {
            String input = f.readLine().toUpperCase();
            for(char i: input.toCharArray()) {
                if(i >= 'A' && i <= 'Z') {
                    occurances[i-'A']++;
                }
            }
        }
        ArrayList<int[]> frequencies = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            if(occurances[i] > 0) {
                frequencies.add(new int[]{i,occurances[i]});
            }
        }
        Collections.sort(frequencies, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if(ints[1] == t1[1]) {
                    return ints[0]-t1[0];
                }
                return t1[1]-ints[1];
            }
        });
        for(int[] i: frequencies) {
            out.println(((char)(i[0]+'A')) + " " + i[1]);
        }
        f.close();
        out.close();
    }
}
