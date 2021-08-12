import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[][] a = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum = (sum+a[i][i])%2;
        }
        int q = Integer.parseInt(f.readLine());
        while(q-- > 0) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int t = Integer.parseInt(st.nextToken());
            if(t == 3) {
                out.print(sum);
            } else {
                st.nextToken();
                sum = (sum+1)%2;
            }
        }
        out.println();
        f.close();
        out.close();
    }
}
