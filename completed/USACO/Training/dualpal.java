/*
ID: strongh2
LANG: JAVA
PROG: dualpal
TASK: dualpal
 */
import java.util.*;
import java.io.*;

public class dualpal {
    public static boolean isPalindrome(String str){
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] != chars[chars.length-i-1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int curNum = s+1;
        int count = 0;
        while(count < n){
            int numBases = 0;
            for(int i = 2; i <= 10; i++){
                String base = Long.toString(curNum,i);
                if(isPalindrome(base)){
                    numBases++;
                }
            }
            if(numBases >= 2){
                out.println(curNum);
                count++;
            }
            curNum++;
        }
        out.close();
        f.close();
    }
}
