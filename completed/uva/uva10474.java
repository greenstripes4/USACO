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
    private static int binarySearch(int[] arr, int tar){
        int low = 0;
        int high = arr.length-1;
        while(low < high){
            int mid = (low+high)/2;
            if(arr[mid] == tar){
                high = mid;
            } else if(arr[mid] < tar){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return arr[low] == tar ? low : -1;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int caseNumber = 1;
        while(true){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            if(N == 0 && Q == 0){
                break;
            }
            int[] arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(f.readLine());
            }
            Arrays.sort(arr);
            out.println("CASE# " + caseNumber + ":");
            for(int i = 0; i < Q; i++){
                int target = Integer.parseInt(f.readLine());
                int ind = binarySearch(arr,target);
                if(ind >= 0){
                    out.println(target + " found at " + (ind+1));
                } else {
                    out.println(target + " not found");
                }
            }
            caseNumber++;
        }
        out.close();
        f.close();
    }
}
