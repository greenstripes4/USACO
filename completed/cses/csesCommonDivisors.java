import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] count = new int[1000001];
        for(int i = 0; i < n; i++) {
            count[Integer.parseInt(st.nextToken())]++;
        }
        for(int i = 1000000; i > 0; i--) {
            int multiples = 0;
            for(int j = i; j <= 1000000 && multiples < 2; j += i) {
                multiples += count[j];
            }
            if(multiples > 1) {
                out.println(i);
                break;
            }
        }
        f.close();
        out.close();
    }
}