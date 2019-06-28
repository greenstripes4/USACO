import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        while((input = f.readLine()) != null){
            char[] sequence = input.toCharArray();
            boolean is_a_palindrome = true;
            boolean is_a_mirrored_string = true;
            int s_length = sequence.length;
            HashMap<Character,Character> reverse = new HashMap<>();
            reverse.put('A','A');
            reverse.put('E','3');
            reverse.put('H','H');
            reverse.put('I','I');
            reverse.put('J','L');
            reverse.put('L','J');
            reverse.put('M','M');
            reverse.put('O','O');
            reverse.put('S','2');
            reverse.put('T','T');
            reverse.put('U','U');
            reverse.put('V','V');
            reverse.put('W','W');
            reverse.put('X','X');
            reverse.put('Y','Y');
            reverse.put('Z','2');
            reverse.put('1','1');
            reverse.put('2','S');
            reverse.put('3','E');
            reverse.put('5','Z');
            reverse.put('8','8');
            for(int i = 0; i < s_length; i++){
                if(!(sequence[i] == sequence[s_length-i-1])){
                    is_a_palindrome = false;
                    break;
                }
            }
            for(int i = 0; i < s_length; i++){
                if(!reverse.containsKey(sequence[i])){
                    is_a_mirrored_string = false;
                    break;
                }
                if(!(sequence[s_length-i-1] == reverse.get(sequence[i]))){
                    is_a_mirrored_string = false;
                    break;
                }
            }
            if(is_a_palindrome && !is_a_mirrored_string){
                System.out.println(input + " -- is a regular palindrome.");
            }
            else if(is_a_palindrome && is_a_mirrored_string){
                System.out.println(input + " -- is a mirrored palindrome.");
            }
            else if(is_a_mirrored_string && !is_a_palindrome){
                System.out.println(input + " -- is a mirrored string.");
            }
            else{
                System.out.println(input + " -- is not a palindrome.");
            }
            System.out.println();
        }
        f.close();
    }
}
