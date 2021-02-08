import java.io.*;
import java.util.*;

public class Main {
    private static long modPow(int a, int b) {
        if(b == 0) {
            return 1;
        }
        if(b%2 == 0) {
            long temp = modPow(a, b/2);
            return (temp*temp)%998244353;
        }
        return (modPow(a, b-1)*a)%998244353;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        out.println(modPow(2, w+h));
        f.close();
        out.close();
    }
}
