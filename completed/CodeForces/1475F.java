import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            char[][] a = new char[n][];
            for(int i = 0; i < n; i++) {
                a[i] = f.readLine().toCharArray();
            }
            f.readLine();
            char[][] b = new char[n][];
            for(int i = 0; i < n; i++) {
                b[i] = f.readLine().toCharArray();
            }
            int[][] diff = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    diff[i][j] = a[i][j] == b[i][j] ? 0 : 1;
                }
            }
            boolean flag = false;
            for(int i = 0; i < n-1; i++) {
                for(int j = 0; j < n-1; j++) {
                    if((diff[i][j]^diff[i+1][j]^diff[i][j+1]^diff[i+1][j+1]) == 1) {
                        flag = true;
                        break;
                    }
                }
                if(flag) {
                    break;
                }
            }
            out.println(flag ? "NO" : "YES");
        }
        f.close();
        out.close();
    }
}
