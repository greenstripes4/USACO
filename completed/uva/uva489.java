import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        while(!((input = f.readLine()).equals("-1"))){
            System.out.println("Round " + input);
            HashSet<Character> word = new HashSet<Character>();
            HashSet<Character> correct_guesses = new HashSet<Character>();
            char[] w = f.readLine().toCharArray();
            char[] g = f.readLine().toCharArray();
            for(char i: w){
                word.add(i);
            }
            String printout = null;
            HashSet<Character> already_guessed = new HashSet<>();
            for(char i: g) {
                if(word.contains(i)){
                    correct_guesses.add(i);
                    if(correct_guesses.size() == word.size()) {
                        printout = "You win.";
                        break;
                    }
                } else {
                    already_guessed.add(i);
                }
                if(already_guessed.size() >= 7){
                    printout = "You lose.";
                    break;
                }
            }
            if(printout == null){
                printout = "You chickened out.";
            }
            System.out.println(printout);
        }
        f.close();
    }
}
