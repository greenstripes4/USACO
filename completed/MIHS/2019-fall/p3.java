import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("spanishConjugations.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("spanishConjugations.out")));
        int N = Integer.parseInt(f.readLine());
        for(int i = 0; i < N; i++){
            String word = f.readLine();
            String firstLetter = word.substring(0,1).toUpperCase();
            String prefix = word.substring(1,word.length()-2);
            String suffix = word.substring(word.length()-2);
            if(suffix.equals("ar")){
                out.println(firstLetter + prefix + "o");
                out.println(firstLetter + prefix + "as");
                out.println(firstLetter + prefix + "a");
                out.println(firstLetter + prefix + "amos");
                out.println(firstLetter + prefix + "an");
            } else if(suffix.equals("er")){
                out.println(firstLetter + prefix + "o");
                out.println(firstLetter + prefix + "es");
                out.println(firstLetter + prefix + "e");
                out.println(firstLetter + prefix + "emos");
                out.println(firstLetter + prefix + "en");
            } else {
                out.println(firstLetter + prefix + "o");
                out.println(firstLetter + prefix + "es");
                out.println(firstLetter + prefix + "e");
                out.println(firstLetter + prefix + "imos");
                out.println(firstLetter + prefix + "en");
            }
        }
        f.close();
        out.close();
    }
}
