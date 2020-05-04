import java.io.*;
import java.util.*;

public class Main{
    private static int minSwaps;
    private static int count;
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void dfs(int[] arr, int swaps){
        boolean sorted = true;
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                sorted = false;
                swap(arr,i,i+1);
                dfs(arr,swaps+1);
                swap(arr,i,i+1);
            }
        }
        if(sorted){
            if(swaps == minSwaps){
                count++;
            } else if(swaps < minSwaps) {
                minSwaps = swaps;
                count = 1;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCase = 1;
        while(true){
            int n = f.nextInt();
            if(n == 0){
                break;
            }
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = f.nextInt();
            }
            minSwaps = Integer.MAX_VALUE;
            count = 0;
            dfs(arr,0);
            out.println("There are " + (minSwaps > 0 ? count : 0) + " swap maps for input data set " + testCase + ".");
            testCase++;
        }
        f.close();
        out.close();
    }
}
