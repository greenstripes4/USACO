import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static boolean check(char ch1, char ch2, char a, char b, char c){
        if (a != ch1 && a != ch2){
            return false;
        }
        if (b != ch1 && b != ch2){
            return false;
        }
        if (c != ch1 && c != ch2){
            return false;
        }
        if (a != ch1 && b != ch1 && c != ch1){
            return false;
        }
        if (a != ch2 && b != ch2 && c != ch2){
            return false;
        }
        return true;
    }
    public static boolean getInd(char ch, char[][] B){
        if (B[0][0] == ch && B[1][1] == ch && B[2][2] == ch){
            return true;
        }
        if (B[0][2] == ch && B[1][1] == ch && B[2][0] == ch){
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if (B[0][i] == ch && B[1][i] == ch && B[2][i] == ch){
                return true;
            }
            if (B[i][0] == ch && B[i][1] == ch && B[i][2] == ch){
                return true;
            }
        }
        return false;
    }
    public static boolean getDuos(char ch1, char ch2, char[][] B) {
        if(check(ch1, ch2, B[0][0], B[1][1], B[2][2])){
            return true;
        }
        if (check(ch1, ch2, B[0][2], B[1][1], B[2][0])){
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if(check(ch1, ch2, B[0][i], B[1][i], B[2][i])){
                return true;
            }
            if(check(ch1, ch2, B[i][0], B[i][1], B[i][2])){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("tttt.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));
        char[][] B = new char[3][3];
        for(int i = 0; i < 3; i++){
            B[i] = f.readLine().toCharArray();
        }
        char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int ind = 0;
        int duos = 0;
        for(char i: letters){
            if(getInd(i,B)){
                ind++;
            }
        }
        for(char i: letters){
            for(char j: letters){
                if(i != j){
                    if(getDuos(i,j,B)){
                        duos++;
                    }
                }
            }
        }
        out.println(ind);
        out.println(duos/2);
        f.close();
        out.close();
    }
}
