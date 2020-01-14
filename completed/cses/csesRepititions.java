/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("cecs.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] sequence = f.readLine().toCharArray();
        int prev = 0;
        int max = 0;
        for(int i = 0; i < sequence.length; i++){
            if(sequence[i] != sequence[prev]){
                max = Math.max(i-prev,max);
                prev = i;
            }
        }
        max = Math.max(sequence.length-prev,max);
        out.println(max);
        f.close();
        out.close();
    }
}
