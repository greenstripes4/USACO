import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));;
        int N = Integer.parseInt(f.readLine());
        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(f.readLine());
            int b = Integer.parseInt(f.readLine());
            int sum = 0;
            for(int j = a; j <= b; j++){
                if(j%2 == 1){
                    sum += j;
                }
            }
            out.println("Case " + (i+1) + ": " + sum);
        }
        f.close();
        out.close();
    }
}
