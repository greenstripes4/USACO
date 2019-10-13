import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
        int N = Integer.parseInt(f.readLine());
        int[] neededLetters = new int[26];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            char[] word1 = st.nextToken().toCharArray();
            char[] word2 = st.nextToken().toCharArray();
            int[] lettersForWord1 = new int[26];
            int[] lettersForWord2 = new int[26];
            for(char j: word1){
                lettersForWord1[(int)j - (int)'a']++;
            }
            for(char k: word2){
                lettersForWord2[(int)k - (int)'a']++;
            }
            for(int l = 0; l < 26; l++){
                neededLetters[l] += Math.max(lettersForWord1[l],lettersForWord2[l]);
            }
        }
        for(int m = 0; m < 26; m++){
            out.println(neededLetters[m]);
        }
        f.close();
        out.close();
    }
}
