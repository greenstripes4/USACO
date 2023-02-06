/*
ID: strongh2
LANG: JAVA
PROG: sort3
TASK: sort3
 */

import java.io.*;
import java.util.*;

public class sort3 {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
        int N = Integer.parseInt(f.readLine());
        int[] arr = new int[N];
        int ones = 0;
        int twos = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(f.readLine());
            switch (arr[i]) {
                case 1:
                    ones++;
                    break;
                case 2:
                    twos++;
                    break;
            }
        }
        int firstTwos = 0;
        int firstThrees = 0;
        for(int i = 0; i < ones; i++) {
            if(arr[i] == 2) {
                firstTwos++;
            } else if(arr[i] == 3) {
                firstThrees++;
            }
        }
        int secondOnes = 0;
        int secondThrees = 0;
        for(int i = 0; i < twos; i++) {
            if(arr[i+ones] == 1) {
                secondOnes++;
            } else if(arr[i+ones] == 3) {
                secondThrees++;
            }
        }
        if(firstTwos < secondOnes) {
            out.println(firstThrees+secondOnes+secondThrees);
        } else {
            out.println(firstTwos+firstThrees+secondThrees);
        }
        out.close();
        f.close();
    }
}
