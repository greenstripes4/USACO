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
        int caseNumber = 1;
        while(!(input = f.readLine()).equals("0")){
            int N = Integer.parseInt(input);
            int[] code = new int[N];
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int i = 0; i < N; i++){
                code[i] = Integer.parseInt(st.nextToken());
            }
            out.println("Game " + caseNumber + ":");
            while(true){
                int[] guess = new int[N];
                StringTokenizer g = new StringTokenizer(f.readLine());
                for(int i = 0; i < N; i++){
                    guess[i] = Integer.parseInt(g.nextToken());
                }
                if(guess[0] == 0){
                    break;
                }
                int[] guessAppearances = new int[9];
                int[] codeAppearances = new int[9];
                int A = 0;
                for(int i = 0; i < N; i++){
                    if(guess[i] == code[i]){
                        A++;
                    } else {
                        guessAppearances[guess[i]-1]++;
                        codeAppearances[code[i]-1]++;
                    }
                }
                int B = 0;
                for(int i = 0; i < 9; i++){
                    B += Math.min(codeAppearances[i],guessAppearances[i]);
                }
                out.println("    (" + A + "," + B + ")");
            }
            caseNumber++;
        }
        out.close();
        f.close();
    }
}
