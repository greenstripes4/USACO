import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[][] C = new long[n+1][k+1];
        for(int i = 0; i <= n; i++) {
            C[i][0] = 1;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                C[i][j] = C[i-1][j]+C[i-1][j-1];
            }
        }
        int[] subfactorial = {0, 0, 1, 2, 9};
        long ans = 1;
        for(int i = 1; i <= k; i++) {
            ans += C[n][i]*subfactorial[i];
        }
        out.println(ans);
        f.close();
        out.close();
    }
}