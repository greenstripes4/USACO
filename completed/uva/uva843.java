import java.io.*;
import java.util.*;

public class Main{
    private static ArrayList<String>[] map;
    private static String[] sentence;
    private static char[] changeTo;
    private static char[] changeFrom;
    private static boolean isValid(char[] word, char[] replacement) {
        for(int i = 0; i < word.length; i++) {
            if((changeTo[word[i]-'a'] != '*' && changeTo[word[i]-'a'] != replacement[i]) || (changeFrom[replacement[i]-'a'] != '*' && changeFrom[replacement[i]-'a'] != word[i])) {
                return false;
            }
            changeTo[word[i]-'a'] = replacement[i];
            changeFrom[replacement[i]-'a'] = word[i];
        }
        return true;
    }
    private static boolean dfs(int idx) {
        if(idx == sentence.length) {
            return true;
        }
        char[] word = sentence[idx].toCharArray();
        ArrayList<String> replacements = map[word.length];
        for(String i: replacements) {
            char[] temp1 = changeTo.clone();
            char[] temp2 = changeFrom.clone();
            if(isValid(word, i.toCharArray()) && dfs(idx+1)) {
                return true;
            }
            changeTo = temp1;
            changeFrom = temp2;
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        map = new ArrayList[17];
        for(int i = 0; i < 17; i++) {
            map[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++) {
            String word = f.readLine();
            map[word.length()].add(word);
        }
        String input;
        while((input = f.readLine()) != null) {
            sentence = input.split(" ");
            changeTo = new char[26];
            changeFrom = new char[26];
            Arrays.fill(changeTo, '*');
            Arrays.fill(changeFrom, '*');
            dfs(0);
            char[] temp = input.toCharArray();
            for(int i = 0; i < temp.length; i++) {
                if(temp[i] != ' ') {
                    temp[i] = changeTo[temp[i]-'a'];
                }
            }
            out.println(new String(temp));
        }
        f.close();
        out.close();
    }
}