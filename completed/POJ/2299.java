import java.io.*;
import java.util.*;

public class Main{
    private static long count;
    private static int[] countSwaps(int[] arr){
        if(arr.length < 2){
            return arr;
        }
        int[] left = countSwaps(Arrays.copyOfRange(arr,0,arr.length/2));
        int[] right = countSwaps(Arrays.copyOfRange(arr,arr.length/2,arr.length));
        int[] res = new int[arr.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(k < arr.length){
            if(i < left.length && (j >= right.length || left[i] < right[j])){
                res[k] = left[i];
                i++;
            } else {
                count += left.length - i;
                res[k] = right[j];
                j++;
            }
            k++;
        }
        return res;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true){
            int n = f.nextInt();
            if(n == 0){
                break;
            }
            count = 0;
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = f.nextInt();
            }
            countSwaps(arr);
            out.println(count);
        }
        f.close();
        out.close();
    }
}
