import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String input;
        while(!(input = f.readLine()).equals("0")){
            int N = Integer.parseInt(input);
            int[] arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(f.readLine());
            }
            int[] aplusb = new int[N*(N-1)];
            int ind = 0;
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < arr.length; j++){
                    if(i != j) {
                        aplusb[ind++] = arr[i] + arr[j];
                    }
                }
            }
            Arrays.sort(aplusb);
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < arr.length; j++){
                    if(i != j) {
                        if(Arrays.binarySearch(aplusb,arr[j] - arr[i]) >= 0){
                            max = Math.max(arr[j],max);
                        }
                    }
                }
            }
            out.println(max != Integer.MIN_VALUE ? max : "no solution");
        }
        f.close();
        out.close();
    }
}
