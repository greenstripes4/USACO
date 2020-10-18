import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = f.nextInt();
        int count = 0;
        for(int i = 0; i < t; i++) {
            double length = f.nextDouble();
            double width = f.nextDouble();
            double depth = f.nextDouble();
            double weight = f.nextDouble();
            if(weight <= 7 && ((length <= 56 && width <= 45 && depth <= 25) || (length+width+depth <= 125))) {
                out.println(1);
                count++;
            } else {
                out.println(0);
            }
        }
        out.println(count);
        f.close();
        out.close();
    }
}
