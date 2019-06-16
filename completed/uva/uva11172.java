import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int numcases = Integer.parseInt(f.readLine());
        for(int i = 0; i < numcases; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if(num1 > num2){
                System.out.println(">");
            }
            else if(num1 < num2){
                System.out.println("<");
            }
            else{
                System.out.println("=");
            }
        }
    }
}
