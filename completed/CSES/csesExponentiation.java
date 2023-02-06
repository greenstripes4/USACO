import java.io.*;
import java.util.*;

public class Main {
    private static long modPow(int a, int b, int m) {
        if(b == 0) {
            return 1;
        }
        if(b%2 == 0) {
            long temp = modPow(a, b/2, m);
            return (temp*temp)%m;
        }
        return (modPow(a, b-1, m)*a)%m;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            out.println(modPow(a, b, 1000000007));
        }
        f.close();
        out.close();
    }
}