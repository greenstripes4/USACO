import java.io.*;
import java.util.*;

public class Main {
    private static int gcd(int a, int b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int N = Integer.parseInt(f.readLine());
            if(N == 0) {
                break;
            }
            int[] arr = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(f.readLine());
            }
            int x = 0;
            int y = 0;
            for(int i = 0; i < N; i++) {
                for(int j = i+1; j < N; j++) {
                    if(gcd(arr[i], arr[j]) == 1) {
                        x++;
                    }
                    y++;
                }
            }
            if(x == 0) {
                out.println("No estimate for this data set.");
            } else {
                out.printf("%.6f\n", Math.sqrt(6.0*y/x));
            }
        }
        f.close();
        out.close();
    }
}