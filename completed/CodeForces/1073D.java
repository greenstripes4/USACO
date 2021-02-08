import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        long T = Long.parseLong(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        long c = 0;
        while(true) {
            long C1 = 0;
            long C2 = 0;
            for(int i = 0; i < n; i++) {
                if(a[i] <= T-C2) {
                    C1++;
                    C2 += a[i];
                }
            }
            if(C1 == 0) {
                break;
            }
            c += T/C2*C1;
            T %= C2;
        }
        out.println(c);
        f.close();
        out.close();
    }
}
