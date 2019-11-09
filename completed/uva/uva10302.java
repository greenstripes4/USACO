import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));;
        String input;
        while((input = f.readLine()) != null){
            int N = Integer.parseInt(input);
            long sum = 0;
            for(long i = 0; i <= N; i++){
                sum += i*i*i;
            }
            out.println(sum);
        }
        f.close();
        out.close();
    }
}
