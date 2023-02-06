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
    public static long maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        long currentSum = nums[0];
        long maxSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            currentSum += nums[i];
            if(currentSum < nums[i]){
                currentSum = nums[i];
            }
            if(currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("cecs.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        out.println(maxSubArray(arr));
        f.close();
        out.close();
    }
}
