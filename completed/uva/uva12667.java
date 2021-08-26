import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] solved = new boolean[n][t];
        int[][] res = new int[n][2];
        for(int[] i: res) {
            i[0] = -1;
            i[1] = -1;
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int time = Integer.parseInt(st.nextToken());
            int id = Integer.parseInt(st.nextToken())-1;
            int problem = st.nextToken().charAt(0)-'A';
            boolean verdict = st.nextToken().equals("Yes");
            if(verdict && !solved[problem][id]) {
                solved[problem][id] = true;
                res[problem][0] = time;
                res[problem][1] = id;
            }
        }
        for(int i = 0; i < n; i++) {
            out.print((char) ('A'+i));
            out.print(" " + (res[i][0] < 0 ? "-" : res[i][0]));
            out.println(" " + (res[i][1] < 0 ? "-" : res[i][1]+1));
        }
        f.close();
        out.close();
    }
}