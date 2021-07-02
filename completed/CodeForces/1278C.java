import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] a = new int[2*n];
            int d = 0;
            for(int i = 0; i < 2*n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if(a[i] == 1) {
                    d++;
                } else {
                    d--;
                }
            }
            HashMap<Integer, Integer> m = new HashMap<>();
            m.put(0, 0);
            int c = 0;
            for(int i = n; i < 2*n; i++) {
                if(a[i] == 1) {
                    c++;
                } else {
                    c--;
                }
                if(!m.containsKey(c)) {
                    m.put(c, i-n+1);
                }
            }
            int min = 2*n+1;
            if(m.containsKey(d)) {
                min = Math.min(min, m.get(d));
            }
            c = 0;
            for(int i = n-1; i >= 0; i--) {
                if(a[i] == 1) {
                    c++;
                } else {
                    c--;
                }
                if(m.containsKey(d-c)) {
                    min = Math.min(min, n-i+m.get(d-c));
                }
            }
            out.println(min);
        }
        f.close();
        out.close();
    }
}