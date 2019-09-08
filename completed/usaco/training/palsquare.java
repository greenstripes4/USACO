/*
ID: strongh2
LANG: JAVA
PROG: palsquare
TASK: palsquare
 */
import java.util.*;
import java.io.*;

public class palsquare {
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
        BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        int base = Integer.parseInt(f.readLine());
        for(int i = 1; i <= 300; i++){
            String square = Long.toString(i*i,base);
            if(isPalindrome(square)){
                out.println(Long.toString(i,base).toUpperCase() + " " + square.toUpperCase());
            }
        }
        out.close();
        f.close();
    }
}
