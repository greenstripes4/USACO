import java.io.*;
import java.util.*;

public class Main{
    public static char[] subArray(char[] arr){
        char[] subArr= new char[arr.length - 1];
        for(int i = 0; i < arr.length - 1; i++){
            subArr[i] = arr[i];
        }
        return subArr;
    }
    public static int binaryToDecimal(char[] binaryRep){
        int pow = 0;
        int decimalRep = 0;
        while(binaryRep.length != 0){
            int currentDigit = Character.getNumericValue(binaryRep[binaryRep.length - 1]);
            binaryRep = subArray(binaryRep);
            int val = 1;
            for(long i = 0; i < pow; i++){
                val *= 2;
            }
            decimalRep += currentDigit*val;
            pow++;
        }
        return decimalRep;
    }
    public static char[] baseTenToBaseThree(int decimalRep){
        return Long.toString(decimalRep,3).toCharArray();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("digits.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("digits.out")));
        char[] binary = f.readLine().toCharArray();
        char[] baseThree = f.readLine().toCharArray();
        ArrayList<Integer> possibleNums = new ArrayList<>();
        for(int i = 0; i < binary.length; i++){
            char change = '0';
            if(binary[i] == '0'){
                change = '1';
            }
            char[] temp = binary.clone();
            temp[i] = change;
            possibleNums.add(binaryToDecimal(temp));
        }
        for(int j: possibleNums){
            char[] comparator = baseTenToBaseThree(j);
            if(comparator.length == baseThree.length) {
                int diffCount = 0;
                for (int k = 0; k < comparator.length; k++) {
                    if(comparator[k] != baseThree[k]){
                        diffCount++;
                    }
                }
                if(diffCount == 1){
                    out.println(j);
                }
            }
        }
        out.close();
        f.close();
    }
}
