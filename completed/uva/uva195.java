import java.io.*;
import java.util.*;

public class Main {
    private static LinkedList<String> allDistinctPermutations;
    private static HashSet<String> seenPermutations;
    private static void generateAllPermutations(Character[] word, boolean[] usedCharacters, String permutation) {
        if(permutation.length() == word.length) {
            allDistinctPermutations.add(permutation);
            return;
        }
        for(int i = 0; i < word.length; i++) {
            if(!usedCharacters[i] && !seenPermutations.contains(permutation+word[i])) {
                usedCharacters[i] = true;
                seenPermutations.add(permutation+word[i]);
                generateAllPermutations(word,usedCharacters,permutation+word[i]);
                usedCharacters[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int words = Integer.parseInt(f.readLine());
        for(int w = 0; w < words; w++) {
            int[] characterValues = new int[128];
            for(int i = 'A'; i <= 'Z'; i++) {
                characterValues[i] = (i-'A')*2;
            }
            for(int i = 'a'; i <= 'z'; i++) {
                characterValues[i] = (i-'a')*2+1;
            }
            char[] word = f.readLine().toCharArray();
            Character[] comparableWord = new Character[word.length];
            for(int i = 0; i < word.length; i++) {
                comparableWord[i] = word[i];
            }
            Arrays.sort(comparableWord, new Comparator<Character>() {
                @Override
                public int compare(Character character, Character t1) {
                    return characterValues[character]-characterValues[t1];
                }
            });
            allDistinctPermutations = new LinkedList<>();
            seenPermutations = new HashSet<>();
            generateAllPermutations(comparableWord,new boolean[word.length],"");
            for(String i: allDistinctPermutations) {
                out.println(i);
            }
        }
        f.close();
        out.close();
    }
}
