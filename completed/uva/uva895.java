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
        ArrayList<int[]> words = new ArrayList<>();
        String input;
        while(!(input = f.readLine()).equals("#")) {
            int[] frequency = new int[26];
            for(char i: input.toCharArray()) {
                frequency[i-'a']++;
            }
            words.add(frequency);
        }
        while(!(input = f.readLine()).equals("#")) {
            StringTokenizer st = new StringTokenizer(input);
            int[] lettersAvailable = new int[26];
            while(st.hasMoreTokens()) {
                lettersAvailable[st.nextToken().charAt(0)-'a']++;
            }
            int count = 0;
            for(int[] i: words) {
                boolean valid = true;
                for(int j = 0; j < 26; j++) {
                    if(lettersAvailable[j] < i[j]) {
                        valid = false;
                        break;
                    }
                }
                if(valid) {
                    count++;
                }
            }
            out.println(count);
        }
        f.close();
        out.close();
    }
}
