import java.io.*;
//O(1)
//2
//637
//-120
//0
//-43
//100
//1
//1000
//-1000
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int input_cases = Integer.parseInt(f.readLine());
        for(int i = 0; i < input_cases; i++){
            int n = Integer.parseInt(f.readLine());
            System.out.println(Math.abs(((((n*63+7492)*5)-498)/10)%10));
        }
    }
}
