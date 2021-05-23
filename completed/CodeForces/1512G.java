import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[] sieve = new int[10000001];
        for(int i = 1; i <= 10000000; i++) {
            for(int j = i; j <= 10000000; j += i) {
                sieve[j] += i;
            }
        }
        int[] min = new int[10000001];
        for(int i = 1; i <= 10000000; i++) {
            if(sieve[i] <= 10000000 && min[sieve[i]] == 0) {
                min[sieve[i]] = i;
            }
        }
        int t = f.nextInt();
        while(t-- > 0) {
            int ans = min[f.nextInt()];
            if(ans == 0) {
                ans--;
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}