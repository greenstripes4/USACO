import java.io.*;
import java.util.*;

public class Main{
    private static int[] P = {1253, 142, 468, 586, 1368, 69, 101, 70, 625, 44, 0, 497, 315, 671, 868, 251, 88, 687, 798, 463, 393, 90, 2, 22, 90, 52};
    private static int totalWordsOfLengthX;
    private static long getSBC(char[] word) {
        long SBC = 0;
        for(int i = 1; i <= word.length; i++) {
            SBC += ((long)i)*P[word[i-1]-'a'];
        }
        return SBC;
    }
    private static long getTotalSBC(char[] word, int current, int[] cnt) {
        if(current == word.length) {
            totalWordsOfLengthX++;
            return getSBC(word);
        }
        boolean isEven = current%2 == 0;
        long totalSBC = 0;
        for(char i = 'a'; i <= 'z'; i++) {
            boolean isVowel = i == 'a' || i == 'e' || i == 'i' || i =='o' || i == 'u';
            if(((isEven && !isVowel) || (!isEven && isVowel)) && cnt[i-'a'] < 2) {
                word[current] = i;
                cnt[i-'a']++;
                totalSBC += getTotalSBC(word, current+1, cnt);
                cnt[i-'a']--;
            }
        }
        return totalSBC;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long[][][] memoization = new long[8][26][2];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 26; j++) {
                Arrays.fill(memoization[i][j], -1);
            }
        }
        int N = Integer.parseInt(f.readLine());
        for(int t = 0; t < N; t++) {
            char[] word = f.readLine().toCharArray();
            long currentSBC = getSBC(word);
            if(memoization[word.length][word[0]-'a'][0] == -1) {
                totalWordsOfLengthX = 0;
                int[] occurances = new int[26];
                occurances[word[0]-'a']++;
                long totalSBC = getTotalSBC(word, 1, occurances);
                memoization[word.length][word[0]-'a'][0] = totalWordsOfLengthX;
                memoization[word.length][word[0]-'a'][1] = totalSBC;
            }
            out.println(currentSBC*memoization[word.length][word[0]-'a'][0] < memoization[word.length][word[0]-'a'][1] ? "below" : "above or equal");
        }
        f.close();
        out.close();
    }
}
