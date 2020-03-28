/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null){
            String top = input;
            String bottom = f.readLine();
            if(top.length() < bottom.length()){
                top = bottom;
                bottom = input;
            }
            int[] teethTop = new int[top.length()+2*bottom.length()];
            int[] teethBottom = new int[bottom.length()];
            char[] arr1 = top.toCharArray();
            char[] arr2 = bottom.toCharArray();
            for(int i = 0; i < arr1.length; i++){
                teethTop[i+bottom.length()] = Character.getNumericValue(arr1[i]);
            }
            for(int i = 0; i < arr2.length; i++){
                teethBottom[i] = Character.getNumericValue(arr2[i]);
            }
            int minSize = bottom.length()+top.length();
            for(int i = -bottom.length(); i <= top.length(); i++){
                boolean valid = true;
                for(int j = 0; j < bottom.length(); j++){
                    if(teethTop[j+i+bottom.length()] + teethBottom[j] > 3){
                        valid = false;
                        break;
                    }
                }
                if(valid){
                    minSize = Math.min(minSize,i < 0 ? top.length()-i : Math.max(top.length(),i+bottom.length()));
                }
            }
            out.println(minSize);
        }
        out.close();
        f.close();
    }
}
