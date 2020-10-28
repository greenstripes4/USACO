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
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int sum = 0;
            int min = 0;
            int max = 0;
            while(st.hasMoreTokens()) {
                int next = Integer.parseInt(st.nextToken());
                sum += next;
                min = Math.min(min, sum);
                max = Math.max(max, sum-min);
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}
