/*
ID: strongh2
LANG: JAVA
PROG: moobuzz
TASK: moobuzz
 */

import java.io.*;
import java.util.StringTokenizer;

public class moobuzz {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("moobuzz.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
        //out.println(Integer.parseInt(f.readLine())*15/8);
        int N = Integer.parseInt(f.readLine());
        int count = 0;
        int num = 0;
        while(count != N){
            num++;
            if(num%3 != 0 && num%5 != 0){
                count++;
            }
        }
        out.println(num);
        out.close();
        f.close();
    }
}
