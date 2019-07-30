import java.io.*;
import java.math.BigInteger;
/*
O(1)
2000
3600
4515
2001
*/

public class Main {
    public static boolean mod(BigInteger x, long y){
        BigInteger num = x.divide(BigInteger.valueOf(y));
        BigInteger closest = BigInteger.valueOf(y).multiply(num);
        if(closest.equals(x)){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main (String args[]) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        boolean first = true;
        String input;
        while ((input = f.readLine()) != null) {
            if(!first) {
                System.out.println();
            }
            first = false;
            BigInteger year = new BigInteger(input);
            boolean isLeapYear = (mod(year, 4) && !mod(year, 100)) || (mod(year, 400));
            boolean isHuluculu = (mod(year, 15));
            boolean isBulukulu = (mod(year, 55)) && isLeapYear;
            if(isLeapYear){
                System.out.println("This is leap year.");
            }
            if(isHuluculu){
                System.out.println("This is huluculu festival year.");
            }
            if(isBulukulu){
                System.out.println("This is bulukulu festival year.");
            }
            if(!isBulukulu && !isHuluculu && !isLeapYear){
                System.out.println("This is an ordinary year.");
            }
        }
    }
}
