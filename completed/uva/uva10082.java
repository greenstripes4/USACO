import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        HashMap<Character,Character> one_to_the_left = new HashMap<>();
        one_to_the_left.put('1','`');
        one_to_the_left.put('2','1');
        one_to_the_left.put('3','2');
        one_to_the_left.put('4','3');
        one_to_the_left.put('5','4');
        one_to_the_left.put('6','5');
        one_to_the_left.put('7','6');
        one_to_the_left.put('8','7');
        one_to_the_left.put('9','8');
        one_to_the_left.put('0','9');
        one_to_the_left.put('-','0');
        one_to_the_left.put('=','-');
        one_to_the_left.put('W','Q');
        one_to_the_left.put('E','W');
        one_to_the_left.put('R','E');
        one_to_the_left.put('T','R');
        one_to_the_left.put('Y','T');
        one_to_the_left.put('U','Y');
        one_to_the_left.put('I','U');
        one_to_the_left.put('O','I');
        one_to_the_left.put('P','O');
        one_to_the_left.put('[','P');
        one_to_the_left.put(']','[');
        one_to_the_left.put('\\',']');
        one_to_the_left.put('S','A');
        one_to_the_left.put('D','S');
        one_to_the_left.put('F','D');
        one_to_the_left.put('G','F');
        one_to_the_left.put('H','G');
        one_to_the_left.put('J','H');
        one_to_the_left.put('K','J');
        one_to_the_left.put('L','K');
        one_to_the_left.put(';','L');
        one_to_the_left.put('\'',';');
        one_to_the_left.put('X','Z');
        one_to_the_left.put('C','X');
        one_to_the_left.put('V','C');
        one_to_the_left.put('B','V');
        one_to_the_left.put('N','B');
        one_to_the_left.put('M','N');
        one_to_the_left.put(',','M');
        one_to_the_left.put('.',',');
        one_to_the_left.put('/','.');
        one_to_the_left.put(' ',' ');
        while((input = f.readLine()) != null){
            char[] letters = input.toCharArray();
            for(char i: letters){
                System.out.print(one_to_the_left.get(i));
            }
            System.out.println();
        }
        f.close();
    }
}
