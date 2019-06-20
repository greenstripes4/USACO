import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(f.readLine());
        for(int i = 0; i<cases; i++){
            int misscount = 0;
            String input = f.readLine();
            for(int j = 0; j < 3; j++){
                if(input.charAt(j) != "one".charAt(j)){
                    misscount++;
                }
            }
            if(misscount <= 1){
                System.out.println(1);
                continue;
            }
            misscount = 0;
            for(int k = 0; k < 3; k++){
                if(input.charAt(k) != "two".charAt(k)){
                    misscount++;
                }
            }
            if(misscount <= 1){
                System.out.println(2);
                continue;
            }
            System.out.println(3);
        }
    }
}
