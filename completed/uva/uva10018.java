import java.io.*;
import java.util.*;

public class Main {
    public static long sum_with_reverse(long x){
        int reverse = 0;
        long y = x;
        while(y != 0){
            reverse *= 10;
            reverse += y%10;
            y /= 10;
        }
        return reverse + x;
    }
    public static boolean is_palindrome(long x){
        char[] sequence = Long.toString(x).toCharArray();
        int s_length = sequence.length;
        boolean is_a_palindrome = true;
        for(int i = 0; i < s_length; i++){
            if(!(sequence[i] == sequence[s_length-i-1])){
                is_a_palindrome = false;
                break;
            }
        }
        return is_a_palindrome;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int numcases = Integer.parseInt(f.readLine());
        for(int i = 0; i < numcases; i++){
            long number = Long.parseLong(f.readLine());
            number = sum_with_reverse(number);
            int count = 1;
            while(!(is_palindrome(number))){
                count++;
                number = sum_with_reverse(number);
            }
            System.out.println(count + " " + number);
        }
        f.close();
    }
}
