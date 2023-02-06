import java.io.*;
import java.util.*;

public class Main {
    static int max = 0;
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

    public static void maxNumCows(int[] cows, int ind, int sum, int count){
        if(count > max){
            max = count;
        }
        if(ind >= cows.length || count+cows.length-ind <= max){
            return;
        }
        if(!carries(sum,cows[ind])){
            maxNumCows(cows,ind+1,sum+cows[ind],count+1);
        }
        maxNumCows(cows,ind+1,sum,count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("escape.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("escape.out")));
        int numCows = Integer.parseInt(f.readLine());
        int[] cows = new int[numCows];
        for(int i = 0; i < numCows; i++){
            cows[i] = Integer.parseInt(f.readLine());
        }
        max = 0;
        maxNumCows(cows,0,0,0);
        out.println(max);
        out.close();
        f.close();
    }
}
