import java.io.*;
import java.util.*;

public class Main {
    public static boolean carries(int curSum, int addend){
        while(curSum != 0 && addend != 0){
            int digitOfSum = curSum%10;
            int digitOfAddend = addend%10;
            if(digitOfSum + digitOfAddend >= 10){
                return true;
            }
            curSum /= 10;
            addend /= 10;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("escape.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("escape.out")));
        int numCows = Integer.parseInt(f.readLine());
        int[] mask = new int[numCows];
        for(int i=0; i < numCows; i++) {
            mask[i] = 1 << i;
        }
        int[] cows = new int[numCows];
        for(int i = 0; i < numCows; i++){
            cows[i] = Integer.parseInt(f.readLine());
        }
        int max = 0;
        for(int j = 1; j < Math.pow(2,numCows); j++){
            /*
            char[] binary = Integer.toBinaryString(j).toCharArray();
            int diff = numCows-binary.length;
            int count = 0;
            int sum = 0;
            for(int k = 0; k < binary.length; k++){
                if(binary[k] == '1'){
                    if(!carries(sum,cows[diff+k])){
                        count++;
                        sum += cows[diff+k];
                    } else {
                        break;
                    }
                }
            }
            */
            int count = 0;
            int sum = 0;
            for(int k=0; k<numCows; k++){
                if ((j & mask[k]) != 0) {
                    if(!carries(sum,cows[k])){
                        count++;
                        sum += cows[k];
                    } else {
                        break;
                    }
                }
            }
            if(count > max){
                max = count;
            }
        }
        out.println(max);
        out.close();
        f.close();
    }
}
