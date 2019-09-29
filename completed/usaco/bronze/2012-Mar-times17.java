import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main{
    public static String binAdd(String a, String b) {
        char[] aStr = a.toCharArray();
        char[] bStr = b.toCharArray();
        int[] result = new int[1010];
        int alen = aStr.length;
        int blen = bStr.length;
        for(int i = 0; i< 1001; i++) {
            int aVal = i<alen ? aStr[alen-i-1] - '0':0;
            int bVal = i<blen ? bStr[blen-i-1] - '0':0;;
            result[1009 - i] = result[1009 - i] + aVal + bVal;
            if(result[1009 - i] >= 2) {
                result[1009 - i] -= 2;
                result[1008 - i] += 1;
            }
        }
        StringBuilder resultStr = new StringBuilder();
        int i=0;
        while(result[i] == 0){
            i++;
        }
        while(i<1010){
            resultStr.append(result[i]);
            i++;
        }
        return resultStr.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("times17.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("times17.out")));
        String binStr = f.readLine();
        out.println(binAdd(binStr, binStr+"0000"));
        out.close();
        f.close();
    }
}
