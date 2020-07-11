import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = 1;
        while(true) {
            int n = Integer.parseInt(f.readLine());
            if(n == 0) {
                break;
            }
            int[][] arr = new int[n][n];
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                for(int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int steps = n-1;
            int r = 0;
            int c = 0;
            out.print("Case " + testcases + ":");
            while(steps > 0) {
                int sum = 0;
                int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
                for(int i = 0; i < 4; i++) {
                    for(int j = 0; j < steps; j++) {
                        sum += arr[r][c];
                        r += directions[i][0];
                        c += directions[i][1];
                    }
                }
                r++;
                c++;
                steps -= 2;
                out.print(" " + sum);
            }
            if(n%2 == 1) {
                out.print(" " + arr[n/2][n/2]);
            }
            out.println();
            testcases++;
        }
        f.close();
        out.close();
    }
}
