import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int numcases = Integer.parseInt(f.readLine());
        for(int i = 0; i < numcases; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());
            int[] x = {num1,num2,num3};
            Arrays.sort(x);
            System.out.println("Case " + Integer.toString(i+1) + ": " + x[1]);
        }
    }
}
