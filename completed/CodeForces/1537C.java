import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] h = new int[n];
            for(int i = 0; i < n; i++) {
                h[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(h);
            if(n == 2) {
                out.print(h[0]);
                for(int i = 1; i < n; i++) {
                    out.print(" " + h[i]);
                }
                out.println();
                continue;
            }
            int split = 0;
            for(int i = 1; i < n-1; i++) {
                if(h[i+1]-h[i] < h[split+1]-h[split]) {
                    split = i;
                }
            }
            out.print(h[split+1]);
            for(int i = split+2; i < n; i++) {
                out.print(" " + h[i]);
            }
            for(int i = 0; i <= split; i++) {
                out.print(" " + h[i]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}