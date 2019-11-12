import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));;
        int n = Integer.parseInt(f.readLine());
        for(int i = 0; i < n; i++){
            double length = Double.parseDouble(f.readLine());
            double width = length*6.0/10.0;
            double radius = length*2.0/10.0;
            out.printf("%.2f", Math.PI*radius*radius);
            out.print(" ");
            out.printf("%.2f", (length*width) - (Math.PI*radius*radius));
            out.println();
        }
        f.close();
        out.close();
    }
}
