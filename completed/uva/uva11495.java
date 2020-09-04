import java.io.*;
import java.util.*;
public class Main {
    private static int split(int[] arr, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int inversions = 0;
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
    private static int swaps(int[] arr) {
        if(arr.length <= 1) {
            return 0;
        }
        int[] left = Arrays.copyOfRange(arr,0,arr.length/2);
        int[] right = Arrays.copyOfRange(arr,arr.length/2,arr.length);
        return swaps(left)+swaps(right)+split(arr,left,right);
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int N = f.nextInt();
            if(N == 0) {
                break;
            }
            int[] arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = f.nextInt();
            }
            out.println(swaps(arr)%2 == 0 ? "Carlos" : "Marcelo");
        }
        f.close();
        out.close();
    }
}
