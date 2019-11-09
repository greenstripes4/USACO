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
            StringTokenizer st = new StringTokenizer(input);
            long c = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            c = c*n;
            long total = 0;
            while (c >= n){
                total += c/n;
                c = c/n + (c%n);
            }
            out.println(total);
        }
        f.close();
        out.close();
    }
}
