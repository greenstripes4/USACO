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
        HashMap<Character,Double> elements = new HashMap<>();
        elements.put(' ',0.0);
        elements.put('C',12.01);
        elements.put('H',1.008);
        elements.put('O',16.00);
        elements.put('N',14.01);
        int N = Integer.parseInt(f.readLine());
        for(int i = 0; i < N; i++){
            char[] str = f.readLine().toCharArray();
            double total = 0;
            int repeat = 0;
            char element = ' ';
            for(char j: str){
                if(j == 'C'){
                    total += (Math.max(repeat,1)*elements.get(element));
                    element = 'C';
                    repeat = 0;
                } else if(j == 'H'){
                    total += (Math.max(repeat,1)*elements.get(element));
                    element = 'H';
                    repeat = 0;
                } else if(j == 'O'){
                    total += (Math.max(repeat,1)*elements.get(element));
                    element = 'O';
                    repeat = 0;
                } else if(j == 'N'){
                    total += (Math.max(repeat,1)*elements.get(element));
                    element = 'N';
                    repeat = 0;
                } else      {
                    repeat *= 10;
                    repeat += Character.getNumericValue(j);
                }
            }
            total += (Math.max(repeat,1)*elements.get(element));
            out.printf("%.3f",total);
            out.println();
        }
        out.close();
        f.close();
    }
}
