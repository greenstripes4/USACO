import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static int digitalRoot(int x){
        if(x < 10){
            return x;
        }
        else{
            int y = 0;
            while(x > 0){
                y += x%10;
                x = x/10;
            }
            return digitalRoot(y);
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while(!((input = f.readLine()).equals("0"))){
            System.out.println(digitalRoot(Integer.parseInt(input)));
        }
    }
}
