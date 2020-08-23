import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0")) {
            int firstGuess = Integer.parseInt(input);
            String firstResponse = f.readLine();
            int low = 0;
            int high = 11;
            if(firstResponse.equals("too high") && firstGuess < high) {
                high = firstGuess;
            } else if(firstResponse.equals("too low") && firstGuess > low) {
                low = firstGuess;
            } else if(firstResponse.equals("right on")) {
                if(firstGuess > low && firstGuess < high) {
                    out.println("Stan may be honest");
                } else {
                    out.println("Stan is dishonest");
                }
                continue;
            }
            while(true) {
                int guess = Integer.parseInt(f.readLine());
                String response = f.readLine();
                if(response.equals("too high") && guess < high) {
                    high = guess;
                } else if(response.equals("too low") && guess > low) {
                    low = guess;
                } else if(response.equals("right on")) {
                    if(guess > low && guess < high) {
                        out.println("Stan may be honest");
                    } else {
                        out.println("Stan is dishonest");
                    }
                    break;
                }
            }
        }
        f.close();
        out.close();
    }
}
