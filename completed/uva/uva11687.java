import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("END")) {
            String x = input;
            String prevX = String.valueOf(x.length());
            if(x.equals(prevX)) {
                out.println(1);
            } else {
                int count = 0;
                while(!x.equals(prevX)) {
                    prevX = x;
                    x = String.valueOf(x.length());
                    count++;
                }
                out.println(count);
            }
        }
        f.close();
        out.close();
    }
}
