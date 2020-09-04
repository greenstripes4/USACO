import java.io.*;
import java.math.BigInteger;
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
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            boolean[] returned = new boolean[N+1];
            st = new StringTokenizer(f.readLine());
            for(int i = 0; i < R; i++) {
                returned[Integer.parseInt(st.nextToken())] = true;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= N; i++) {
                if(!returned[i]) {
                    sb.append(i);
                    sb.append(" ");
                }
            }
            out.println(sb.length() == 0 ? "*" : sb);
        }
        f.close();
        out.close();
    }
}
