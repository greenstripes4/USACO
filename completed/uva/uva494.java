import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            boolean start = true;
            int words = 0;
            for(char i: input.toCharArray()) {
                if(Character.isLetter(i)) {
                    if(start) {
                        words++;
                        start = false;
                    }
                } else {
                    start = true;
                }
            }
            out.println(words);
        }
        f.close();
        out.close();
    }
}
