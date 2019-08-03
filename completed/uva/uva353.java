import java.io.*;
import java.util.ArrayList;
/*
O(n^2)
boy
adam
madam
tot
t
*/

public class Main {
    public static boolean isPalindrome(String s){
        boolean palindrome = true;
        char[] letters = s.toCharArray();
        for(int i = 0; i < letters.length; i++){
            if(letters[i] != letters[letters.length-1-i]){
                palindrome = false;
                break;
            }
        }
        return palindrome;
    }
    public static void main (String args[]) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = f.readLine()) != null) {
            ArrayList<String> palindromes = new ArrayList<>();
            for (int i = 0; i < input.length(); i++) {
                for (int j = i + 1; j <= input.length(); j++) {
                    if(isPalindrome(input.substring(i,j)) && !palindromes.contains(input.substring(i,j))){
                        palindromes.add(input.substring(i,j));
                    }
                }
            }
            System.out.println("The string '" + input + "' contains " + palindromes.size() + " palindromes.");
        }
    }
}
