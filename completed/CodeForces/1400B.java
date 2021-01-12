import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(f.readLine());
            int w1 = Integer.parseInt(st.nextToken());
            int w2 = Integer.parseInt(st.nextToken());
            if(w1 > w2) {
                int tempN = n1;
                n1 = n2;
                n2 = tempN;
                int tempW = w1;
                w1 = w2;
                w2 = tempW;
            }
            int max = 0;
            for(int j = 0; j <= Math.min(n1, c1/w1); j++) {
                int k = Math.min(n2, (c1-j*w1)/w2);
                int l = Math.min(n1-j, c2/w1);
                int m = Math.min(n2-k, (c2-l*w1)/w2);
                max = Math.max(max, j+k+l+m);
            }
            out.println(max);
        }
        f.close();
        out.close();
    }
}