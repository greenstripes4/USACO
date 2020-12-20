import sun.awt.im.CompositionArea;

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
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] s = new int[k][2];
        int[][] e = new int[k][2];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(f.readLine());
            s[i][0] = Integer.parseInt(st.nextToken());
            s[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(f.readLine());
            e[i][0] = Integer.parseInt(st.nextToken());
            e[i][1] = Integer.parseInt(st.nextToken());
        }
        out.println(2*n+m-3+n*(m-1));
        for(int i = 0; i < n-1; i++) {
            out.print("U");
        }
        for(int i = 0; i < m-1; i++) {
            out.print("L");
        }
        boolean left = false;
        for(int i = 0; i < n; i++) {
            if(i > 0) {
                out.print("D");
            }
            for(int j = 0; j < m-1; j++) {
                out.print(left ? "L" : "R");
            }
            left = !left;
        }
        out.println();
        f.close();
        out.close();
    }
}
