import java.io.*;
import java.util.*;

public class Main {
    public static int sum(int num){
        int sum = 0;
        while (num != 0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
    public static int sum2(int[] digits){
        int sum = 0;
        for(int i: digits){
            sum += i;
        }
        return sum;
    }
    public static int depth(int num){
        int sum = sum(num);
        if(sum == 9) {
            return 1;
        }
        return 1 + depth(sum);
    }
    public static boolean divisible(int num){
        int sum = sum(num);
        if(sum == 9) {
            return true;
        } else if (sum < 10){
            return false;
        }
        return divisible(sum);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0")){
            char[] chars = input.toCharArray();
            int[] digits = new int[chars.length];
            for(int i = 0; i < chars.length; i++){
                digits[i] = Character.getNumericValue(chars[i]);
            }
            int sum = sum2(digits);
            int depth = 1;
            if(sum == 9){
                out.println(input + " is a multiple of 9 and has 9-degree " + depth + ".");
            } else {
                if(divisible(sum)) {
                    depth += depth(sum);
                    out.println(input + " is a multiple of 9 and has 9-degree " + depth + ".");
                } else {
                    out.println(input + " is not a multiple of 9.");
                }
            }
        }
        f.close();
        out.close();
    }
}
