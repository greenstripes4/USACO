import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(n%2 == 0) {
            boolean flag = false;
            for(int i = 0; i < n/2; i++) {
                if(!Arrays.equals(a[i], a[n-i-1])) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
            n /= 2;
        }
        out.println(n);
        f.close();
        out.close();
    }
}