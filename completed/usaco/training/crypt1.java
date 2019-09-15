/*
ID: strongh2
LANG: JAVA
PROG: crypt1
TASK: crypt1
 */

import java.util.*;
import java.io.*;

public class crypt1 {
    public static boolean contains(int[] arr, int o){
        for(int i: arr){
            if(i == o){
                return true;
            }
        }
        return false;
    }
    public static boolean isValid(int[] f1, int[] f2, int[] d){
        if(f1[0] == 0 || f2[0] == 0){
            return false;
        }
        int fac = f1[0] * 100 + f1[1] * 10 + f1[2];
        int n1 = fac * f2[0];
        int n2 = fac * f2[1];
        int n1copy = n1;
        ArrayList<Integer> num1 = new ArrayList<>();
        while (n1copy != 0){
            num1.add(n1copy%10);
            n1copy /= 10;
        }
        int n2copy = n2;
        ArrayList<Integer> num2 = new ArrayList<>();
        while (n2copy != 0){
            num2.add(n2copy%10);
            n2copy /= 10;
        }
        if(num1.size() != 3 || num2.size() != 3){
            return false;
        }
        for(int i: num1){
            if(!contains(d,i)){
                return false;
            }
        }
        for(int j: num2){
            if(!contains(d,j)){
                return false;
            }
        }
        int product = n1 + n2*10;
        ArrayList<Integer> p = new ArrayList<>();
        while(product != 0){
            p.add(product%10);
            product /= 10;
        }
        if(p.size() != 4){
            return false;
        }
        for(int k: p){
            if(!contains(d,k)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        int numDigits = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] digits = new int[numDigits];
        for(int i = 0; i < numDigits; i++){
            digits[i] = Integer.parseInt(st.nextToken());
        }
        int[] factor1 = new int[3];
        int[] factor2 = new int[2];
        int count = 0;
        for(int j = 0; j < numDigits; j++){
            for(int k = 0; k < numDigits; k++){
                for(int l = 0; l < numDigits; l++){
                    for(int m = 0; m < numDigits; m++){
                        for(int n = 0; n < numDigits; n++){
                            factor1[0] = digits[j];
                            factor1[1] = digits[k];
                            factor1[2] = digits[l];
                            factor2[0] = digits[m];
                            factor2[1] = digits[n];
                            if(isValid(factor1,factor2,digits)){
                                count++;
                            }
                        }
                    }
                }
            }
        }
        out.println(count);
        out.close();
        f.close();
    }
}
