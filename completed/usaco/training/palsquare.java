/*
ID: strongh2
LANG: JAVA
PROG: palsquare
TASK: palsquare
 */


import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class palsquare {
    public static boolean isPalindrome(String str){
        char[] arr = str.toCharArray();
        for(int i = 0; i < str.length()/2; i++){
            if(arr[i] != arr[str.length() - i - 1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        int B = Integer.parseInt(f.readLine());
        for(int i = 1; i <= 300; i++) {
            String str = Integer.toString(i * i, B);
            str = str.toUpperCase();
            String str2 = Integer.toString(i,B).toUpperCase();
            if (isPalindrome(str)) {
                out.println(str2 + " " + str);
            }
        }
        f.close();
        out.close();
    }
}
