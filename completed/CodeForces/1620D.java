import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] a = new int[n];
            boolean[] mod = new boolean[3];
            for(int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                mod[a[i]%3] = true;
            }
            Arrays.sort(a);
            boolean flag = false;
            for(int i: a) {
                if(i == a[n-1]-1) {
                    flag = true;
                    break;
                }
            }
            if(!mod[1] && !mod[2]) {
                out.println(a[n-1]/3);
            } else if(!mod[1] || !mod[2]) {
                out.println(a[n-1]/3+1);
            } else if(a[0] == 1 || (a[n-1]%3 == 1 && flag)) {
                out.println((a[n-1]+2)/3+1);
            } else {
                out.println((a[n-1]+1)/3+1);
            }
        }
        f.close();
        out.close();
    }
}
