import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        int testcases = 1;
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            double N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int D = (int)(Math.ceil(N/R))-1;
            out.println("Case " + testcases + ": " + (D <= 26 ? D : "impossible"));
            testcases++;
        }
        f.close();
        out.close();
    }
}
