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
        //BufferedReader f = new BufferedReader(new FileReader("loan.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        char[][] arr = new char[n][n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = f.readLine().toCharArray();
        }
        int[][] val = new int[n][n];
        val[0][0] = arr[0][0] == '*' ? 0:1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == '*'){
                    val[i][j] = 0;
                } else {
                    if(i-1 >= 0){
                        val[i][j] += val[i-1][j];
                        val[i][j] = val[i][j] % 1000000007;
                    }
                    if(j-1 >= 0){
                        val[i][j] += val[i][j-1];
                        val[i][j] = val[i][j] % 1000000007;
                    }
                }
            }
        }
        out.println(val[n-1][n-1]);
        out.close();
        f.close();
    }
}
