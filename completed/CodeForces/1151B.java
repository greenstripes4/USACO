import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];
        int xor = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
            xor ^= a[i][0];
        }
        if(xor > 0) {
            out.println("TAK");
            out.print("1");
            for(int i = 1; i < n; i++) {
                out.print(" 1");
            }
            out.println();
        } else {
            int r = -1;
            int c = -1;
            for(int i = 0; i < n; i++) {
                for(int j = 1; j < m; j++) {
                    if(a[i][j] != a[i][0]) {
                        r = i;
                        c = j;
                        break;
                    }
                }
                if(r >= 0) {
                    break;
                }
            }
            if(r >= 0) {
                out.println("TAK");
                for(int i = 0; i < n; i++) {
                    if(i > 0) {
                        out.print(" ");
                    }
                    if(i == r) {
                        out.print(c+1);
                    } else {
                        out.print(1);
                    }
                }
            } else {
                out.println("NIE");
            }
        }
        f.close();
        out.close();
    }
}