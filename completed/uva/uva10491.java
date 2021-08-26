import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            double b = Integer.parseInt(st.nextToken());
            double a = Integer.parseInt(st.nextToken());
            double c = Integer.parseInt(st.nextToken());
            out.printf("%.5f\n", (a/(a+b)*(a-1)/(a+b-c-1)+b/(a+b)*a/(a+b-c-1)));
        }
        f.close();
        out.close();
    }
}
