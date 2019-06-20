import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(f.readLine());
        for(int i = 0; i<cases; i++){
            String input = f.readLine();
            if(input.equals("1") || input.equals("4") || input.equals("78")){
                System.out.println("+");
            }
            else if((input.charAt(input.length() - 1)) == '5' && (input.charAt(input.length() - 2)) == '3'){
                System.out.println("-");
            }
            else if((input.charAt(input.length() - 1)) == '4' && (input.charAt(0)) == '9'){
                System.out.println("*");
            }
            else{
                System.out.println("?");
            }
        }
    }
}
