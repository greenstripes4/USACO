import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(f.readLine());
        System.out.println("Lumberjacks:");
        for (int i = 0; i < testCases; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] arr = new int[10];
            int ind = 0;
            while(st.hasMoreTokens()){
                arr[ind] = Integer.parseInt(st.nextToken());
                ind++;
            }
            int[] acopy = arr.clone();
            Arrays.sort(acopy);
            int[] comp = new int[10];
            ind = 0;
            for(int j = arr.length - 1; j >= 0; j--){
                comp[j] = acopy[ind];
                ind++;
            }
            if(Arrays.equals(arr,acopy) || Arrays.equals(arr,comp)){
                System.out.println("Ordered");
            }
            else{
                System.out.println("Unordered");
            }
        }
    }
}
