/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        for(int i = 0; i < N; i++){
            char[] scores = f.readLine().toCharArray();
            int total = 0;
            int consecutive = 1;
            for(char j: scores){
                if (j == 'X'){
                    consecutive = 1;
                } else if (j == 'O'){
                    total += consecutive;
                    consecutive++;
                }
            }
            out.println(total);
        }
        out.close();
        f.close();
    }
}
