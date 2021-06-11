import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            char[] arr = f.readLine().toCharArray();
            if(arr[0] == '0' || arr[n-1] == '0') {
                out.println("NO");
                continue;
            }
            int ones = 0;
            for(char i: arr) {
                if(i == '1') {
                    ones++;
                }
            }
            if(ones%2 == 1) {
                out.println("NO");
                continue;
            }
            out.println("YES");
            char[] a = new char[n];
            char[] b = new char[n];
            int cur = 0;
            char last = ')';
            for(int i = 0; i < n; i++) {
                if(arr[i] == '0') {
                    a[i] = last == ')' ? '(' : ')';
                    last = a[i];
                } else {
                    a[i] = cur < ones/2 ? '(' : ')';
                    cur++;
                }
                b[i] = arr[i] == '0' ? a[i] == '(' ? ')' : '(' : a[i];
            }
            out.println(new String(a));
            out.println(new String(b));
        }
        f.close();
        out.close();
    }
}
