import java.io.*;
import java.util.*;

public class Main{
    private static long solveOneDimensional(long[] arr) {
        long[] dp = new long[arr.length];
        dp[0] = arr[0];
        long max = Math.max(Long.MIN_VALUE, dp[0]);
        for(int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    private static long solveTwoDimensional(long[][] arr) {
        long[][] prefixSums = new long[arr.length][arr[0].length+1];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 1; j <= arr[0].length; j++) {
                prefixSums[i][j] = prefixSums[i][j-1]+arr[i][j-1];
            }
        }
        long max = Long.MIN_VALUE;
        for(int i = 0; i < arr[0].length; i++) {
            for(int j = i; j < arr[0].length; j++) {
                long[] oneDimensionalArr = new long[arr.length];
                for(int k = 0; k < arr.length; k++) {
                    oneDimensionalArr[k] += prefixSums[k][j+1]-prefixSums[k][i];
                }
                max = Math.max(max, solveOneDimensional(oneDimensionalArr));
            }
        }
        return max;
    }
    private static long solveThreeDimensional(long[][][] arr) {
        long[][][] prefixSums = new long[arr.length][arr[0].length][arr[0][0].length+1];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                for(int k = 1; k <= arr[0][0].length; k++) {
                    prefixSums[i][j][k] = prefixSums[i][j][k-1]+arr[i][j][k-1];
                }
            }
        }
        long max = Long.MIN_VALUE;
        for(int i = 0; i < arr[0][0].length; i++) {
            for(int j = i; j < arr[0][0].length; j++) {
                long[][] twoDimensionalArr = new long[arr.length][arr[0].length];
                for(int k = 0; k < arr.length; k++) {
                    for(int l = 0; l < arr[0].length; l++) {
                        twoDimensionalArr[k][l] += prefixSums[k][l][j+1]-prefixSums[k][l][i];
                    }
                }
                max = Math.max(max, solveTwoDimensional(twoDimensionalArr));
            }
        }
        return max;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long testcases = f.nextInt();
        for(int t = 0; t < testcases; t++) {
            if(t > 0) {
                out.println();
            }
            int A = f.nextInt();
            int B = f.nextInt();
            int C = f.nextInt();
            long[][][] arr = new long[A][B][C];
            for(int i = 0; i < A; i++) {
                for(int j = 0; j < B; j++) {
                    for(int k = 0; k < C; k++) {
                        arr[i][j][k] = f.nextLong();
                    }
                }
            }
            out.println(solveThreeDimensional(arr));
        }
        f.close();
        out.close();
    }
}
