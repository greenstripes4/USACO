import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0")){
            char[] num = input.toCharArray();
            int total = 0;
            boolean op = true;
            for(char i: num){
                if(op){
                    total += Character.getNumericValue(i);
                } else {
                    total -= Character.getNumericValue(i);
                }
                op = !op;
            }
            if(total%11 == 0){
                out.println(input + " is a multiple of 11.");
            } else {
                out.println(input + " is not a multiple of 11.");
            }
        }
        f.close();
        out.close();
    }
}
