import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));;
        String input;
        while(!((input = f.readLine()).equals("0"))){
            int num = Integer.parseInt(input);
            String binrep = Integer.toBinaryString(num);
            char[] b = binrep.toCharArray();
            int count = 0;
            for(char i: b){
                if(i == '1'){
                    count++;
                }
            }
            out.println("The parity of " + binrep + " is " +  count + " (mod 2).");
        }
        f.close();
        out.close();
    }
}
