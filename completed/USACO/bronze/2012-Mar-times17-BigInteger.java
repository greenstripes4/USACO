import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main{
    public static BigInteger pow(BigInteger a, BigInteger b){
        BigInteger res = new BigInteger("1");
        for(BigInteger i = new BigInteger("0"); i.compareTo(b)== -1; i = i.add(new BigInteger("1"))){
            res = res.multiply(a);
        }
        return res;
    }
    public static BigInteger mod(BigInteger a, BigInteger b){
        BigInteger q = a.divide(b);
        return a.subtract(b.multiply(q));
    }
    public static BigInteger binToDec(BigInteger bin){
        BigInteger pow = new BigInteger("0");
        BigInteger dec = new BigInteger("0");
        while(bin.compareTo(new BigInteger("0")) != 0){
            BigInteger addend = mod(bin,new BigInteger("10"));
            BigInteger curMul = pow(new BigInteger("2"),pow);
            dec = dec.add(addend.multiply(curMul));
            bin = bin.divide(new BigInteger("10"));
            pow = pow.add(new BigInteger("1"));
        }
        return dec;
    }

    public static BigInteger binToDec(String binStr){
        char[] binChars = binStr.toCharArray();
        BigInteger dec = new BigInteger("0");
        for(int i=0; i<binChars.length; i++) {
            dec = dec.multiply(new BigInteger("2")).add(BigInteger.valueOf(binChars[i] - '0'));
        }
        return dec;
    }

    public static BigInteger decToBin(BigInteger dec){
        StringBuilder sb = new StringBuilder();
        while(dec.compareTo(new BigInteger("0")) != 0){
            BigInteger m = mod(dec,new BigInteger("2"));
            sb.append(m);
            dec = dec.subtract(m);
            dec = dec.divide(new BigInteger("2"));
        }
        sb.reverse();
        return new BigInteger(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("times17.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("times17.out")));
        out.println(decToBin(binToDec(f.readLine()).multiply(new BigInteger("17"))).toString());
        //BigInteger input = new BigInteger(f.readLine());
        //out.println(decToBin(new BigInteger("5")));
        //out.println(binToDec(input));
        //out.println(mod(new BigInteger("3"), new BigInteger("6")));
        //out.println(pow(new BigInteger("3"), new BigInteger("2")).toString());
        //out.println(decToBin(binToDec(input).multiply(new BigInteger("17"))).toString());
        out.close();
        f.close();
    }
}
