/*
ID: strongh2
LANG: JAVA
PROG: runround
TASK: runround
 */

import java.io.*;
import java.util.*;

public class preface {
    private static char getLowerNumeral(int N) {
        if(N >= 1 && N < 5) {
            return 'I';
        }
        if(N >= 5 && N < 10) {
            return 'V';
        }
        if(N >= 10 && N < 50) {
            return 'X';
        }
        if(N >= 50 && N < 100) {
            return 'L';
        }
        if(N >= 100 && N < 500) {
            return 'C';
        }
        if(N >= 500 && N < 1000) {
            return 'D';
        }
        return 'M';
    }
    private static char getUpperNumeral(int N) {
        if(N >= 1 && N < 5) {
            return 'V';
        }
        if(N >= 5 && N < 10) {
            return 'X';
        }
        if(N >= 10 && N < 50) {
            return 'L';
        }
        if(N >= 50 && N < 100) {
            return 'C';
        }
        if(N >= 100 && N < 500) {
            return 'D';
        }
        return 'M';
    }
    private static int getIntegerValue(char roman) {
        if(roman == 'I') {
            return 1;
        }
        if(roman == 'V') {
            return 5;
        }
        if(roman == 'X') {
            return 10;
        }
        if(roman == 'L') {
            return 50;
        }
        if(roman == 'C') {
            return 100;
        }
        if(roman == 'D') {
            return 500;
        }
        return 1000;
    }
    private static StringBuilder getRomanRepresentation(int N) {
        if(N == 0) {
            return new StringBuilder();
        }
        if(N == 1 || N == 5 || N == 10 || N == 50 || N == 100 || N == 500 || N == 1000) {
            return new StringBuilder().append(getLowerNumeral(N));
        }
        if(N == 9) {
            return new StringBuilder("IX");
        }
        if(N >= 90 && N < 100) {
            return new StringBuilder("XC").append(getRomanRepresentation(N-90));
        }
        if(N >= 900 && N < 1000) {
            return new StringBuilder("CM").append(getRomanRepresentation(N-900));
        }
        char lower = getLowerNumeral(N);
        char upper = getUpperNumeral(N);
        int lowerInteger = getIntegerValue(lower);
        int upperInteger = getIntegerValue(upper);
        if(lowerInteger == 1 || lowerInteger == 10 || lowerInteger == 100 || lowerInteger == 1000) {
            if(lowerInteger*4 > N) {
                return new StringBuilder().append(lower).append(getRomanRepresentation(N-lowerInteger));
            }
            return new StringBuilder().append(lower).append(upper).append(getRomanRepresentation(N+lowerInteger-upperInteger));
        }
        if(lowerInteger*2 > N) {
            return new StringBuilder().append(lower).append(getRomanRepresentation(N-lowerInteger));
        }
        return new StringBuilder().append(lower).append(upper).append(N+lowerInteger-upperInteger);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("runround.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
        int N = Integer.parseInt(f.readLine());
        int[] occurences = new int[26];
        for(int i = 1; i <= N; i++) {
            char[] roman = getRomanRepresentation(i).toString().toCharArray();
            for(char j: roman) {
                occurences[j-'A']++;
            }
        }
        if(occurences[8] > 0) {
            out.println("I " + occurences[8]);
        }
        if(occurences[21] > 0) {
            out.println("V " + occurences[21]);
        }
        if(occurences[23] > 0) {
            out.println("X " + occurences[23]);
        }
        if(occurences[11] > 0) {
            out.println("L " + occurences[11]);
        }
        if(occurences[2] > 0) {
            out.println("C " + occurences[2]);
        }
        if(occurences[3] > 0) {
            out.println("D " + occurences[3]);
        }
        if(occurences[12] > 0) {
            out.println("M " + occurences[12]);
        }
        out.close();
        f.close();
    }
}
