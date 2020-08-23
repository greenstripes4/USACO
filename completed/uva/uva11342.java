import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        for(int t = 0; t < N; t++) {
            int K = Integer.parseInt(f.readLine());
            boolean found = false;
            for(int a = 0; a*a <= K; a++) {
                for(int b = a; a*a+b*b <= K; b++) {
                    int c = (int)Math.sqrt(K-a*a-b*b);
                    if(a*a+b*b+c*c == K) {
                        found = true;
                        out.println(a + " " + b + " " + c);
                        break;
                    }
                }
                if(found) {
                    break;
                }
            }
            if(!found) {
                out.println(-1);
            }
        }
        f.close();
        out.close();
    }
}
