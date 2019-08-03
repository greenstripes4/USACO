import java.io.*;
/*
O(n^2)
Madam, Im adam!
Roma tibi subito motibus ibit amor.
Me so hungry!
Si nummi immunis
DONE
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
        while(!((input = f.readLine()).equals("DONE"))){
            input = input.toLowerCase();
            input =input.replaceAll("\\s+","");
            input = input.replaceAll("[^a-zA-Z0-9]", "");
            if(isPalindrome(input)){
                System.out.println("You won't be eaten!");
            }
            else{
                System.out.println("Uh oh..");
            }
        }
    }
}
