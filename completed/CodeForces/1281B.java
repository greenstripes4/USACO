import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = f.nextInt();
        while(t-- > 0) {
            char[] a = f.next().toCharArray();
            char[] b = f.next().toCharArray();
            int[] s = new int[a.length];
            s[a.length-1] = a.length-1;
            for(int i = a.length-2; i >= 0; i--) {
                s[i] = s[i+1];
                if(a[i] < a[s[i+1]]) {
                    s[i] = i;
                }
            }
            for(int i = 0; i < a.length; i++) {
                if(a[i] > a[s[i]]) {
                    char temp = a[i];
                    a[i] = a[s[i]];
                    a[s[i]] = temp;
                    break;
                }
            }
            String sa = new String(a);
            String sb = new String(b);
            if(sa.compareTo(sb) < 0) {
                out.println(sa);
            } else {
                out.println("---");
            }
        }
        f.close();
        out.close();
    }
}