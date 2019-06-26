import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
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
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        while((input = f.readLine()) != null){
            char[] l1 = input.toCharArray();
            char[] l2 = f.readLine().toCharArray();
            int val1 = 0;
            int val2 = 0;
            for(char i: l1){
                int ascii = (int) i;
                if(ascii >= (int) 'a' && ascii <= (int) 'z'){
                    val1 += ((int) i -(int) 'a' + 1);
                }
                else if(ascii >= (int) 'A' && ascii <= (int) 'Z'){
                    val1 += ((int) i -(int) 'A' + 1);
                }

            }
            for(char i: l2){
                int ascii = (int) i;
                if(ascii >= (int) 'a' && ascii <= (int) 'z'){
                    val2 += ((int) i -(int) 'a' + 1);
                }
                else if(ascii >= (int) 'A' && ascii <= (int) 'Z'){
                    val2 += ((int) i -(int) 'A' + 1);
                }

            }
            val1 = digitalRoot(val1);
            val2 = digitalRoot(val2);
            System.out.printf("%.2f", (((double) Math.min(val2,val1) / Math.max(val1,val2)) * 100));
            System.out.println(" %");
        }
        f.close();
    }
}
