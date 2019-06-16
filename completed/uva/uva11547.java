import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int input_cases = Integer.parseInt(f.readLine());
        for(int i = 0; i < input_cases; i++){
            int num = Integer.parseInt(f.readLine());
            System.out.println(Math.abs(((((num*63+7492)*5)-498)/10)%10));
        }
    }
}
