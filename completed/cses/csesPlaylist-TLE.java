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
        int max = 0;
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < arr.length; i++){
            int ind = i + 1;
            HashSet<Integer> seen = new HashSet<>();
            seen.add(arr[i]);
            while(ind < arr.length && !seen.contains(arr[ind])){
                seen.add(arr[ind]);
                ind++;
            }
            max = Math.max(max,ind-i);
        }
        out.println(max);
        f.close();
        out.close();
    }
}
