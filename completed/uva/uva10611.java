/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.util.*;

public class Main{
    private static int binarySearchLow(int[] arr, int val){
        int low = 0;
        int high = arr.length;
        while(low+1 < high){
            int mid = (low+high)/2;
            if(arr[mid] < val){
                low = mid;
            } else {
                high = mid;
            }
        }
        if(arr[low] >= val){
            return -1;
        }
        return low;
    }
    private static int binarySearchHigh(int[] arr, int val){
        int low = 0;
        int high = arr.length-1;
        while(low < high){
            int mid = (low+high)/2;
            if(arr[mid] > val){
                high = mid;
            } else {
                low = mid+1;
            }
        }
        if(arr[high] <= val){
            return -1;
        }
        return high;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        int[] ladies = new int[N];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < N; i++){
            ladies[i] = Integer.parseInt(st.nextToken());
        }
        int Q = Integer.parseInt(f.readLine());
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < Q; i++){
            int luchu = Integer.parseInt(st.nextToken());
            int low = binarySearchLow(ladies,luchu);
            int high = binarySearchHigh(ladies,luchu);
            if(low < 0 && high < 0){
                out.println("X X");
            } else if(low < 0) {
                out.println("X " + ladies[high]);
            } else if(high < 0) {
                out.println(ladies[low] + " X");
            } else {
                out.println(ladies[low] + " " + ladies[high]);
            }
        }
        out.close();
        f.close();
    }
}
