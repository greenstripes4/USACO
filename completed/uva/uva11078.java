import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(f.readLine());
            int[] arr = new int[n];
            for(int j = 0; j < n; j++){
                arr[j] = Integer.parseInt(f.readLine());
            }
            long max = Integer.MIN_VALUE;
            long ans = Integer.MIN_VALUE;
            for(int j = 0; j < n; j++){
                ans = Math.max(ans,max-arr[j]);
                max = Math.max(max,arr[j]);
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}
