import java.io.*;
import java.util.*;

public class Main {
    private static int[] a;
    private static int[] b;
    private static boolean isValid(int x) {
        for(int i: a) {
            boolean found = false;
            for(int j: b) {
                if((x|(i&j)) == x) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(f.readLine());
        b = new int[m];
        for(int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < 512; i++) {
            if(isValid(i)) {
                out.println(i);
                break;
            }
        }
        f.close();
        out.close();
    }
}