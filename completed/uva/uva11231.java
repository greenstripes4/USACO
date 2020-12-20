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
        while(!(input = f.readLine()).equals("0 0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken())-7;
            int m = Integer.parseInt(st.nextToken())-7;
            int c = Integer.parseInt(st.nextToken());
            out.println((n/2)*(m/2+((m+1)/2))+(n%2)*((m+c)/2));
        }
        f.close();
        out.close();
    }
}
