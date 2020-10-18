/*
ID: strongh2
LANG: JAVA
PROG: runround
TASK: runround
 */

import java.io.*;
import java.util.*;

public class runround {
    private static boolean isRunRound(int n){
        int size = 0;
        int orig = n;
        while(n != 0) {
            size++;
            n /= 10;
        }
        int[] arr = new int[size];
        int ind = size-1;
        while(orig != 0){
            arr[ind] = orig%10;
            orig /= 10;
            ind--;
        }
        HashSet<Integer> seen = new HashSet<>();
        int pointer = 0;
        while(seen.size() < size && !seen.contains(arr[pointer])){
            seen.add(arr[pointer]);
            pointer = (pointer+arr[pointer])%size;
        }
        return seen.size() == size && pointer == 0;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("runround.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
        int M = Integer.parseInt(f.readLine())+1;
        while(!isRunRound(M)) {
            M++;
        }
        out.println(M);
        out.close();
        f.close();
    }
}
