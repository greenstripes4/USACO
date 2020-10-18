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
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int sqrt = (int) Math.sqrt(N);
            int sum = 0;
            for(int i = 1; i <= sqrt; i++) {
                if(N%i == 0) {
                    if(i%K != 0) {
                        sum += i;
                    }
                    if(i != N/i && (N/i)%K != 0) {
                        sum += N/i;
                    }
                }
            }
            out.println(sum);
        }
        f.close();
        out.close();
    }
}
