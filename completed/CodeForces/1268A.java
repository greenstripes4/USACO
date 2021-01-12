import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        out.println(n);
        int k = Integer.parseInt(st.nextToken());
        char[] a = f.readLine().toCharArray();
        char[] b = new char[n];
        for(int i = 0; i < k; i++) {
            for(int j = i; j < n; j += k) {
                b[j] = a[i];
            }
        }
        String aCmp = new String(a);
        String bCmp = new String(b);
        if(aCmp.compareTo(bCmp) > 0) {
            for(int i = k-1; i >= 0; i--) {
                if(b[i] < '9') {
                    b[i] = (char) (b[i]+1);
                    break;
                } else {
                    b[i] = '0';
                }
            }
            for(int i = 0; i < k; i++) {
                for(int j = i; j < n; j += k) {
                    b[j] = b[i];
                }
            }
        }
        out.println(b);
        f.close();
        out.close();
    }
}
