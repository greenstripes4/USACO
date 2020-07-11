import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(f.readLine());
            String[] words = new String[N];
            for(int i = 0; i < N ; i++) {
                words[i] = f.readLine();
            }
            int X = words[0].length();
            String lastWord = words[0];
            words[0] = null;
            LinkedList<String> order = new LinkedList<>();
            while(true) {
                order.add(lastWord);
                int longestCommonPrefix = -1;
                int nextWord = -1;
                for(int i = 0; i < N; i++) {
                    if(words[i] != null) {
                        int ind = 0;
                        while (ind < lastWord.length() && ind < words[i].length()) {
                            if (lastWord.charAt(ind) != words[i].charAt(ind)) {
                                break;
                            }
                            ind++;
                        }
                        if (ind > longestCommonPrefix) {
                            longestCommonPrefix = ind;
                            nextWord = i;
                        }
                    }
                }
                if(longestCommonPrefix == -1) {
                    break;
                }
                X += words[nextWord].length()-longestCommonPrefix;
                lastWord = words[nextWord];
                words[nextWord] = null;
            }
            out.println(X);
            for(String i: order) {
                out.println(i);
            }
        }
        f.close();
        out.close();
    }
}
