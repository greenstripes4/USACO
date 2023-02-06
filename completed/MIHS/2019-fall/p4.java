import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("fancyBorder.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fancyBorder.out")));
        out.println("\\--*****--/");
        int N = Integer.parseInt(f.readLine());
        for(int i = 0; i < N; i++){
            String word = f.readLine();
            out.print("|");
            out.print(word);
            for(int j = 0; j < 9-word.length(); j++){
                out.print(" ");
            }
            out.println("|");
        }
        out.println("/--*****--\\");
        f.close();
        out.close();
    }
}
