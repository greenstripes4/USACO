import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
                //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
                //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));
                StringTokenizer st = new StringTokenizer(f.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                out.println(T/A*B);
                f.close();
                out.close();
        }
}
