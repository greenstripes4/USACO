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
        int n = Integer.parseInt(f.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long count = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[i-1]) {
                count += arr[i-1] - arr[i];
                arr[i] = arr[i-1];
            }
        }
        out.println(count);
        f.close();
        out.close();
    }
}
