/*
ID: strongh2
LANG: JAVA
PROG: skidesign
TASK: skidesign
 */
import java.util.*;
import java.io.*;

public class skidesign {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        int N = Integer.parseInt(f.readLine());
        int[] arr = new int[N];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            int height = Integer.parseInt(f.readLine());
            arr[i] = height;
            if(height < min){
                min = height;
            }
            if(height > max){
                max = height;
            }
        }
        int minCost = Integer.MAX_VALUE;
        for(int i = min; i <= max - 17; i++){
            int j = i+17;
            int cost = 0;
            for(int k = 0; k < arr.length; k++){
                if(arr[k] < i){
                    cost += (i - arr[k]) * (i - arr[k]);
                }
                if(arr[k] > j){
                    cost += (arr[k] - j) * (arr[k] - j);
                }
            }
            if(cost < minCost){
                minCost = cost;
            }
        }
        out.println(minCost);
        out.close();
        f.close();
    }
}
