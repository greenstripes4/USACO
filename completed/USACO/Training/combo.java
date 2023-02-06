/*
ID: strongh2
LANG: JAVA
PROG: combo
TASK: combo
 */

import java.util.*;
import java.io.*;

public class combo {
    public static int makeValid(int cur, int n){
        while(cur <= 0){
            cur += n;
        }
        while(cur > n){
            cur -= n;
        }
        return cur;
    }
    public static HashSet<String> allPossibleValidCombinations(int[] combination, int n){
        HashSet<String> validCombinations = new HashSet<>();
        int[][] possible = new int[3][5];
        int ind = 0;
        for(int i = -2; i <= 2; i++){
            possible[0][ind] = makeValid(combination[0] + i,n);
            possible[1][ind] = makeValid(combination[1] + i,n);
            possible[2][ind] = makeValid(combination[2] + i,n);
            ind++;
        }
        for(int j = 0; j < 5;  j++){
            for(int k = 0; k < 5; k++){
                for(int l = 0; l < 5; l++){
                    validCombinations.add(possible[0][j] + " " + possible[1][k] + " " + possible[2][l]);
                }
            }
        }
        return validCombinations;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("combo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        int N = Integer.parseInt(f.readLine());
        int[] farmerJohnsCombination = new int[3];
        int[] masterCombination = new int[3];
        StringTokenizer fjc = new StringTokenizer(f.readLine());
        for(int i = 0; i < 3; i++){
            farmerJohnsCombination[i] =  Integer.parseInt(fjc.nextToken());
        }
        StringTokenizer mc = new StringTokenizer(f.readLine());
        for(int j = 0; j < 3; j++){
            masterCombination[j] = Integer.parseInt(mc.nextToken());
        }
        HashSet<String> farmerPasses = allPossibleValidCombinations(farmerJohnsCombination,N);
        HashSet<String> masterPasses = allPossibleValidCombinations(masterCombination,N);
        farmerPasses.addAll(masterPasses);
        out.println(farmerPasses.size());
        out.close();
        f.close();
    }
}
