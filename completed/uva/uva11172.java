import java.io.*;
import java.util.StringTokenizer;
//O(1)
//10 20
//20 10
//10 10
//-6 -4
//-7 -9
//-3 -3
//1000000001 1000000001
//0 0
//-1000000001 -1000000001
//0 -1000000001
//-1000000001 0

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int cases = Integer.parseInt(f.readLine());
        for(int i = 0; i < cases; i++){
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
