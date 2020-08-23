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
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            while(st.hasMoreTokens()) {
                if(!first) {
                    sb.append(" ");
                }
                sb.append(new StringBuilder(st.nextToken()).reverse());
                first = false;
            }
            out.println(sb);
        }
        f.close();
        out.close();
    }
}
