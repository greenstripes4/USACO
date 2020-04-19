import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = f.nextInt();
        for(int i = 0; i < t; i++){
            int n = f.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; j++){
                arr[j] = f.nextInt();
            }
            Arrays.sort(arr);
            int totalDiscount = 0;
            for(int j = n-3; j >= 0; j -= 3){
                totalDiscount += arr[j];
            }
            out.println(totalDiscount);
        }
        f.close();
        out.close();
    }
}
