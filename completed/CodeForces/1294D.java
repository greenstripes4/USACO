import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int q = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] next = new int[x];
        for(int i = 0; i < x; i++) {
            next[i] = i;
        }
        boolean[] has = new boolean[q+1];
        int min = 0;
        for(int i = 0; i < q; i++) {
            int y = Integer.parseInt(f.readLine());
            if(next[y%x] < q) {
                has[next[y%x]] = true;
                while(has[min]) {
                    min++;
                }
                next[y%x] += x;
            }
            out.println(min);
        }
        f.close();
        out.close();
    }
}
