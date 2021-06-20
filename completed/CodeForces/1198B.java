import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int q = Integer.parseInt(f.readLine());
        int[] s = new int[q];
        int[] t1 = new int[n];
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(f.readLine());
            if(Integer.parseInt(st.nextToken()) == 1) {
                int p = Integer.parseInt(st.nextToken())-1;
                int x = Integer.parseInt(st.nextToken());
                t1[p] = i;
                a[p] = x;
            } else {
                int x = Integer.parseInt(st.nextToken());
                s[i] = x;
            }
        }
        for(int i = q-2; i >= 0; i--) {
            s[i] = Math.max(s[i], s[i+1]);
        }
        out.print(Math.max(a[0], s[t1[0]]));
        for(int i = 1; i < n; i++) {
            out.print(" " + Math.max(a[i], s[t1[i]]));
        }
        out.println();
        f.close();
        out.close();
    }
}