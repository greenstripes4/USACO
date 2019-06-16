import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while(!(input = f.readLine()).equals("0 0 0 0")){
            StringTokenizer st = new StringTokenizer(input);
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());
            int num4 = Integer.parseInt(st.nextToken());
            int add1, add2, add3;
            if(num1<num2){
                add1 = 9*(num1 + 40 -num2);
            } else {
                add1 = 9*(num1-num2);
            }

            if(num3<num2){
                add2 = 9*(num3 + 40 - num2);
            } else {
                add2 = 9*(num3-num2);
            }

            if(num3<num4){
                add3 = 9*(num3+40-num4);
            } else {
                add3 = 9*(num3-num4);
            }

            System.out.println(add1+add2+add3+1080);
        }
    }
}
