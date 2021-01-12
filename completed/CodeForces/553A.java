import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        long[][] iChooseJ = new long[1001][1001];
        iChooseJ[0][0] = 1;
        for(int i = 1; i <= 1000; i++) {
            iChooseJ[i][0] = 1;
            for(int j = 1; j <= 1000; j++) {
                iChooseJ[i][j] = (iChooseJ[i-1][j]+iChooseJ[i-1][j-1])%1000000007;
            }
        }
        int k = Integer.parseInt(f.readLine());
        long ways = 1;
        int sum = 0;
        for(int i = 0; i < k; i++) {
            int ci = Integer.parseInt(f.readLine());
            ways = (ways*iChooseJ[sum+ci-1][ci-1])%1000000007;
            sum += ci;
        }
        out.println(ways);
        f.close();
        out.close();
    }
}
