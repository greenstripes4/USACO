import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken())-1;
        st =  new StringTokenizer(f.readLine());
        long[] a = new long[n];
        int start = 0;
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            if(a[i] < a[start] || (a[i] == a[start] && (x-i+n)%n < (x-start+n)%n)) {
                start = i;
            }
        }
        long[] b = new long[n];
        int i = start;
        do {
            i = (i+1)%n;
            b[i] = a[i]-a[start]-1;
        } while(i != x);
        i = (i+1)%n;
        while(i != start) {
            b[i] = a[i]-a[start];
            i = (i+1)%n;
        }
        b[start] = a[start]*n+(x-start+n)%n;
        out.print(b[0]);
        for(int j = 1; j < n; j++) {
            out.print(" " + b[j]);
        }
        out.println();
        f.close();
        out.close();
    }
}
