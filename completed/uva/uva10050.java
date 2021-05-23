import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(f.readLine());
            int P = Integer.parseInt(f.readLine());
            boolean[] c = new boolean[N+1];
            for(int i = 0; i < P; i++) {
                int h = Integer.parseInt(f.readLine());
                for(int j = h; j <= N; j += h) {
                    c[j] = true;
                }
            }
            int count = 0;
            for(int i = 1; i <= N; i++) {
                if(i%7 == 0 || i%7 == 6) {
                    continue;
                }
                if(c[i]) {
                    count++;
                }
            }
            out.println(count);
        }
        f.close();
        out.close();
    }
}
