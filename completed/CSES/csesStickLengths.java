/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("cecs.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long target = arr[arr.length/2];
        long total = 0;
        for(int i = 0; i < n; i++){
            total += Math.abs(arr[i] - target);
        }
        out.println(total);
        f.close();
        out.close();
    }
}
