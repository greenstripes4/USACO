import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));;
        int cases = Integer.parseInt(f.readLine());
        for(int i = 0; i < cases; i++){
            long warriors = Long.parseLong(f.readLine());
            long ans = (long) (Math.sqrt((2.0*warriors)+(1.0/4.0))-(1.0/2.0));
            out.println(ans);
        }
        f.close();
        out.close();
    }
}
