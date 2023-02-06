/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.util.*;
import java.io.*;

public class Main {
    public static int length(int k){
        if(k == -1){
            return 0;
        }
        int x = length(k-1);
        return x + (k+3) + x;
    }
    public static char helper(int n, int k){
        if(n > length(k)){
            return helper(n,k+1);
        }
        if(n <= length(k-1)){
            return helper(n, k-1);
        }
        n = n - length(k-1);
        if(n <= k+3){
            return n == 1 ? 'm':'o';
        }
        n = n - k - 3;
        return helper(n,k-1);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("moo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moo.out")));
        int N = Integer.parseInt(f.readLine());
        out.println(helper(N,0));
        out.close();
        f.close();
    }
}
