import java.io.*;
import java.util.*;
public class Main {
    private static long split(long[] arr, long[] left, long[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        long inversions = 0;
        for(int i = 0; i < arr.length; i++) {
            if(leftIndex < left.length && rightIndex < right.length) {
                if(left[leftIndex] <= right[rightIndex]) {
                    arr[i] = left[leftIndex];
                    leftIndex++;
                } else {
                    arr[i] = right[rightIndex];
                    rightIndex++;
                    inversions += left.length-leftIndex;
                }
            } else if(leftIndex < left.length) {
                arr[i] = left[leftIndex];
                leftIndex++;
            } else {
                arr[i] = right[rightIndex];
                rightIndex++;
            }
        }
        return inversions;
    }
    private static long swaps(long[] arr) {
        if(arr.length <= 1) {
            return 0;
        }
        long[] left = Arrays.copyOfRange(arr,0,arr.length/2);
        long[] right = Arrays.copyOfRange(arr,arr.length/2,arr.length);
        return swaps(left)+swaps(right)+split(arr,left,right);
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(f.hasNext()) {
            int n = f.nextInt();
            long[] arr = new long[n];
            for(int i = 0; i < n; i++) {
                arr[i] = f.nextLong();
            }
            out.println(swaps(arr));
        }
        f.close();
        out.close();
    }
}
