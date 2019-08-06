/*
ID: strongh2
LANG: JAVA
PROG: digits
TASK: digits
*/

import java.io.*;
import java.util.ArrayList;
import java.math.BigInteger;

public class Main {
    public static int mod(BigInteger a, int b){
        BigInteger x = a.divide(BigInteger.valueOf((long) b));
        BigInteger val = x.multiply(BigInteger.valueOf((long) b));
        return Integer.parseInt(a.subtract(val).toString());
    }
    public static int binConverter(BigInteger binRep){
        int pow = 0;
        int dec = 0;
        while(!(binRep.equals(new BigInteger("0")))){
            int dig = mod(binRep, 10);
            binRep = binRep.divide(new BigInteger("10"));
            int val = 1;
            for(long i = 0; i < pow; i++){
                val *= 2;
            }
            dec += (dig*val);
            pow++;
        }
        return dec;
    }
    public static String toBaseThree(long decRep){
        return Long.toString(decRep,3);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("digits.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("digits.out")));
        char[] bin = f.readLine().toCharArray();
        char[] tri = f.readLine().toCharArray();
        ArrayList<Integer> pos = new ArrayList<>();
        for(int i = 0; i < bin.length; i++){
            char change = bin[i];
            if(change == '1'){
                change = '0';
            }
            else{
                change = '1';
            }
            char[] temp = bin.clone();
            temp[i] = change;
            StringBuilder newBinary = new StringBuilder();
            for(char j: temp){
                newBinary.append(j);
            }
            pos.add(binConverter(new BigInteger(newBinary.toString())));
        }
        for(int k: pos){
            char[] comparator = toBaseThree(k).toCharArray();
            int count = 0;
            if(comparator.length != tri.length){
                continue;
            }
            for(int l = 0; l < comparator.length; l++){
                if(!(comparator[l] == tri[l])){
                    count++;
                }
            }
            if(count == 1){
                out.println(k);
                break;
            }
        }
        out.close();
        f.close();
    }
}
