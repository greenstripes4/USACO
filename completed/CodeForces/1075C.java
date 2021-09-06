import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n+1];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(f.readLine());
        }
        a[n] = 1000000000;
        Arrays.sort(a);
        int[] end = new int[m];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            st.nextToken();
            if(x1 == 1) {
                end[i] = x2;
            }
        }
        Arrays.sort(end);
        int min = n+m;
        int j = m-1;
        for(int i = n; i >= 0; i--) {
            while(j >= 0 && end[j] >= a[i]) {
                j--;
            }
            min = Math.min(min, m-j-1+i);
        }
        out.println(min);
        f.close();
        out.close();
    }
}