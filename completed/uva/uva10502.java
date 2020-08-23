import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("0")) {
            int n = Integer.parseInt(input);
            int m = Integer.parseInt(f.readLine());
            char[][] grid = new  char[n][m];
            for(int i = 0; i < n; i++) {
                grid[i] = f.readLine().toCharArray();
            }
            int[][] sums = new int[n+1][m+1];
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    sums[i][j] = sums[i-1][j]+sums[i][j-1]-sums[i-1][j-1]+(grid[i-1][j-1]-'0');
                }
            }
            int ans = 0;
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    for(int k = i; k <= n; k++) {
                        for(int l = j; l <= m; l++) {
                            if((k-i+1)*(l-j+1) == sums[k][l]-sums[k][j-1]-sums[i-1][l]+sums[i-1][j-1]) {
                                ans++;
                            }
                        }
                    }
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}
