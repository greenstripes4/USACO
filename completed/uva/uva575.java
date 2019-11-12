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
            char[] arr = input.toCharArray();
            int total = 0;
            int power = 1;
            for(int i = arr.length-1; i >= 0; i--){
                int value = Character.getNumericValue(arr[i]);
                total += value*(Math.pow(2,power) - 1);
                power++;
            }
            out.println(total);
        }
        f.close();
        out.close();
    }
}
